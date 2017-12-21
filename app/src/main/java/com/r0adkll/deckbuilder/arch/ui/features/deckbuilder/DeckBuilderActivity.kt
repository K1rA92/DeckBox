package com.r0adkll.deckbuilder.arch.ui.features.deckbuilder


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.view.animation.FastOutLinearInInterpolator
import android.support.v7.app.AlertDialog
import android.view.DragEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.evernote.android.state.State
import com.ftinc.kit.kotlin.extensions.*
import com.jakewharton.rxbinding2.widget.textChanges
import com.jakewharton.rxrelay2.PublishRelay
import com.jakewharton.rxrelay2.Relay
import com.r0adkll.deckbuilder.R
import com.r0adkll.deckbuilder.arch.domain.features.cards.model.PokemonCard
import com.r0adkll.deckbuilder.arch.domain.features.cards.model.StackedPokemonCard
import com.r0adkll.deckbuilder.arch.domain.features.decks.model.Deck
import com.r0adkll.deckbuilder.arch.domain.features.decks.repository.DeckValidator
import com.r0adkll.deckbuilder.arch.ui.components.BaseActivity
import com.r0adkll.deckbuilder.arch.ui.components.drag.EditDragListener
import com.r0adkll.deckbuilder.arch.ui.components.drag.TabletDragListener
import com.r0adkll.deckbuilder.arch.ui.features.carddetail.CardDetailActivity
import com.r0adkll.deckbuilder.arch.ui.features.deckbuilder.di.DeckBuilderComponent
import com.r0adkll.deckbuilder.arch.ui.features.deckbuilder.pageradapter.DeckBuilderPagerAdapter
import com.r0adkll.deckbuilder.arch.ui.features.deckbuilder.di.DeckBuilderModule
import com.r0adkll.deckbuilder.arch.ui.features.exporter.DeckExportActivity
import com.r0adkll.deckbuilder.arch.ui.features.importer.DeckImportActivity
import com.r0adkll.deckbuilder.arch.ui.features.search.SearchActivity
import com.r0adkll.deckbuilder.arch.ui.widgets.PokemonCardView
import com.r0adkll.deckbuilder.internal.analytics.Analytics
import com.r0adkll.deckbuilder.internal.analytics.Event
import com.r0adkll.deckbuilder.internal.di.AppComponent
import com.r0adkll.deckbuilder.util.bindOptionalParcelable
import com.r0adkll.deckbuilder.util.bindOptionalParcelableList
import com.r0adkll.deckbuilder.util.extensions.isVisible
import com.r0adkll.deckbuilder.util.extensions.plusAssign
import com.r0adkll.deckbuilder.util.extensions.snackbar
import com.r0adkll.deckbuilder.util.extensions.uiDebounce
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.*
import gov.scstatehouse.houseofcards.di.HasComponent
import gov.scstatehouse.houseofcards.util.ImeUtils
import io.pokemontcg.model.SuperType
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_deck_builder.*
import timber.log.Timber
import javax.inject.Inject


class DeckBuilderActivity : BaseActivity(), HasComponent<DeckBuilderComponent>, DeckBuilderUi,
        DeckBuilderUi.Intentions, DeckBuilderUi.Actions {

    private val deck: Deck? by bindOptionalParcelable(EXTRA_DECK)
    private val imports: ArrayList<PokemonCard>? by bindOptionalParcelableList(EXTRA_IMPORT)

    @State override var state: DeckBuilderUi.State = DeckBuilderUi.State.DEFAULT

    @Inject lateinit var renderer: DeckBuilderRenderer
    @Inject lateinit var presenter: DeckBuilderPresenter
    @Inject lateinit var validator: DeckValidator

    private val pokemonCardClicks: Relay<PokemonCardView> = PublishRelay.create()
    private val editCardIntentions: EditCardIntentions = EditCardIntentions()
    private val saveDeck: Relay<Unit> = PublishRelay.create()
    private val editDeckClicks: Relay<Boolean> = PublishRelay.create()

    private val countPadding: Float by lazy { dpToPx(16f) }
    private val countPaddingTop: Float by lazy { dpToPx(16f) }
    private val formatPaddingTop: Float by lazy { dpToPx(8f) }
    private val panelOffsetTop: Float by lazy { dpToPx(48f) }

    private lateinit var component: DeckBuilderComponent
    private lateinit var adapter: DeckBuilderPagerAdapter
    private var savingSnackBar: Snackbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deck_builder)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        appbar?.setNavigationOnClickListener {
            if (state.hasChanged) {
                Analytics.event(Event.SelectContent.Action("close_deck_editor"))
                AlertDialog.Builder(this)
                        .setTitle(R.string.deckbuilder_unsaved_changes_title)
                        .setMessage(R.string.deckbuilder_unsaved_changes_message)
                        .setPositiveButton(R.string.dialog_action_yes, { dialog, _ ->
                            Analytics.event(Event.SelectContent.Action("discarded_changes"))
                            dialog.dismiss()
                            supportFinishAfterTransition()
                        })
                        .setNegativeButton(R.string.dialog_action_no, { dialog, _ ->
                            Analytics.event(Event.SelectContent.Action("kept_changes"))
                            dialog.dismiss()
                        })
                        .show()
            }
            else {
                supportFinishAfterTransition()
            }
        }

        adapter = DeckBuilderPagerAdapter(this, pokemonCardClicks, editCardIntentions)
        pager.adapter = adapter
        pager.offscreenPageLimit = 3
        tabs.setupWithViewPager(pager)
        fab.setOnClickListener {
            val superType = when(tabs.selectedTabPosition) {
                0 -> SuperType.POKEMON
                1 -> SuperType.TRAINER
                2 -> SuperType.ENERGY
                else -> SuperType.POKEMON
            }
            Analytics.event(Event.SelectContent.Action("add_new_card"))
            val intent = SearchActivity.createIntent(this, superType, state.allCards)
            startActivityForResult(intent, SearchActivity.RC_PICK_CARD)
        }

        tabletDropZone?.let {
            TabletDragListener.attach(it, pager, { card ->
                editCardIntentions.addCardClicks.accept(listOf(card))
            })
        }

        EditDragListener.attach(dropZone, object : EditDragListener.DropListener {

            override fun onAddCard(card: PokemonCard) {
                editCardIntentions.addCardClicks.accept(listOf(card))
            }


            override fun onRemoveCard(card: PokemonCard) {
                editCardIntentions.removeCardClicks.accept(card)
            }

        }, { card ->
            validator.validate(state.allCards, card) == null
        })

        slidingLayout.addPanelSlideListener(object : SlidingUpPanelLayout.PanelSlideListener {
            override fun onPanelSlide(panel: View, slideOffset: Float) {
                interpolateCardCounter(panel, slideOffset)

                val infoBarOffset = calculateAlpha(slideOffset, .95f)
                infoBar.alpha = infoBarOffset
                infoBar.elevation = infoBarOffset * dpToPx(4f)
                text_input_deck_name.alpha = calculateAlpha(slideOffset, .80f)
                text_input_deck_description.alpha = calculateAlpha(slideOffset, .65f)
//                format_expanded.alpha = 1f - (slideOffset * 9f).coerceAtMost(1f)
//                format_standard.alpha = 1f - (slideOffset * 9f).coerceAtMost(1f)
//                formatStandardDetail.alpha = calculateAlpha(slideOffset, .40f)
//                formatExpandedDetail.alpha = calculateAlpha(slideOffset, .40f)

                if (slideOffset > 0f && !infoBar.isVisible()) {
                    infoBar.visible()
                }
                else if (slideOffset == 0f && infoBar.isVisible()) {
                    infoBar.invisible()
                }
            }

            override fun onPanelStateChanged(panel: View, previousState: SlidingUpPanelLayout.PanelState, newState: SlidingUpPanelLayout.PanelState) {
                if (previousState != COLLAPSED && newState == COLLAPSED) {
                    ImeUtils.hideIme(panel)
                }
            }

            private fun calculateAlpha(offset: Float, ratio: Float): Float = (offset - (1 - ratio)).coerceAtLeast(0f) / ratio


            private fun interpolateCardCounter(panel: View, offset: Float) {
                val bottom = if (formatExpandedDetail.isVisible()){
                    formatExpandedDetail.bottom
                } else if (formatStandardDetail.isVisible()) {
                    formatStandardDetail.bottom
                } else {
                    text_input_deck_description.bottom
                }

                val distance = ((bottom - cardCount.top) + countPaddingTop)
                val distanceYRatio = distance / (panel.height - panelOffsetTop)
                val distanceX = (cardCount.left - countPadding)

                val cardOffset = offset.coerceAtMost(distanceYRatio) / distanceYRatio
                val translationY = distance * cardOffset
                val translationX = distanceX * cardOffset
                cardCount.translationY = translationY
                cardCount.translationX = -translationX
            }


        })

        infoBar.setNavigationOnClickListener {
            slidingLayout.panelState = COLLAPSED
        }

        if (state.deck == null && deck != null) {
            state = state.copy(
                    deck = deck,
                    pokemonCards = deck!!.cards.filter { it.supertype == SuperType.POKEMON },
                    trainerCards = deck!!.cards.filter { it.supertype == SuperType.TRAINER },
                    energyCards = deck!!.cards.filter { it.supertype == SuperType.ENERGY },
                    name = deck?.name,
                    description = deck?.description
            )
        }

        if (imports != null) {
            state = state.copy(
                    pokemonCards = imports!!.filter { it.supertype == SuperType.POKEMON },
                    trainerCards = imports!!.filter { it.supertype == SuperType.TRAINER },
                    energyCards = imports!!.filter { it.supertype == SuperType.ENERGY }
            )
        }

        renderer.start()
        presenter.start()

        disposables += pokemonCardClicks
                .subscribe {
                    Analytics.event(Event.SelectContent.PokemonCard(it.card?.id ?: "unknown"))
                    CardDetailActivity.show(this, it)
                }
    }


    override fun onDestroy() {
        presenter.stop()
        renderer.stop()
        super.onDestroy()
    }


    override fun onBackPressed() {
        if (state.hasChanged) {
            Analytics.event(Event.SelectContent.Action("close_deck_editor"))
            AlertDialog.Builder(this)
                    .setTitle(R.string.deckbuilder_unsaved_changes_title)
                    .setMessage(R.string.deckbuilder_unsaved_changes_message)
                    .setPositiveButton(R.string.dialog_action_yes, { dialog, _ ->
                        Analytics.event(Event.SelectContent.Action("discarded_changes"))
                        dialog.dismiss()
                        super.onBackPressed()
                    })
                    .setNegativeButton(R.string.dialog_action_no, { dialog, _ ->
                        Analytics.event(Event.SelectContent.Action("kept_changes"))
                        dialog.dismiss()
                    })
                    .show()
        }
        else {
            super.onBackPressed()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val result = SearchActivity.parseResult(requestCode, resultCode, data)
        result?.let { editCardIntentions.addCardClicks.accept(it) }

        val importResult = DeckImportActivity.parseResults(resultCode, requestCode, data)
        importResult?.let {
            Analytics.event(Event.SelectContent.Action("import_cards"))
            editCardIntentions.addCardClicks.accept(it)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_deck_builder, menu)
        return true
    }


    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        val saveItem = menu.findItem(R.id.action_save)
        saveItem.isVisible = state.hasChanged && !state.isSaving

        val editItem = menu.findItem(R.id.action_edit)
        val finishEditItem = menu.findItem(R.id.action_finish_edit)
        editItem.isVisible = !state.isEditing
        finishEditItem.isVisible = state.isEditing
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_edit -> {
                editDeckClicks.accept(true)
                true
            }
            R.id.action_finish_edit -> {
                editDeckClicks.accept(false)
                true
            }
            R.id.action_import -> {
                Analytics.event(Event.SelectContent.MenuAction("import_decklist"))
                DeckImportActivity.show(this)
                true
            }
            R.id.action_export -> {
                Analytics.event(Event.SelectContent.MenuAction("export_decklist"))
                val exportDeck = Deck("", "", "", state.allCards, 0L)
                startActivity(DeckExportActivity.createIntent(this, exportDeck))
                true
            }
            R.id.action_save -> {
                Analytics.event(Event.SelectContent.MenuAction("save_deck"))
                saveDeck.accept(Unit)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun getComponent(): DeckBuilderComponent {
        return component
    }


    override fun setupComponent(component: AppComponent) {
        this.component = component.plus(DeckBuilderModule(this))
        this.component.inject(this)
    }


    override fun render(state: DeckBuilderUi.State) {
        this.state = state
        renderer.render(state)
    }


    override fun addCards(): Observable<List<PokemonCard>> {
        return editCardIntentions.addCardClicks
                .flatMap {
                    Observable.fromIterable(it)
                            .filter { card ->
                                val result = validator.validate(state.allCards, card)
                                if (result != null) {
                                    adapter.wiggleCard(card)
                                    // Display error to user
                                    snackbar(result)
                                    false
                                } else {
                                    true
                                }
                            }
                            .toList()
                            .toObservable()
                }
    }


    override fun removeCard(): Observable<PokemonCard> {
        return editCardIntentions.removeCardClicks
    }


    override fun editDeckClicks(): Observable<Boolean> {
        return editDeckClicks
    }


    override fun editDeckName(): Observable<String> {
        return inputDeckName.textChanges()
                .map { it.toString() }
                .uiDebounce()
    }


    override fun editDeckDescription(): Observable<String> {
        return inputDeckDescription.textChanges()
                .map { it.toString() }
                .uiDebounce()
    }


    override fun saveDeck(): Observable<Unit> {
        return saveDeck
    }


    override fun showSaveAction(hasChanges: Boolean) {
        invalidateOptionsMenu()
    }


    override fun showCardCount(count: Int) {
        cardCount.totalCount(count)
    }


    override fun showPokemonCards(cards: List<StackedPokemonCard>) {
        adapter.setCards(SuperType.POKEMON, cards)
        cardCount.countStacks(SuperType.POKEMON, cards)
    }


    override fun showTrainerCards(cards: List<StackedPokemonCard>) {
        adapter.setCards(SuperType.TRAINER, cards)
        cardCount.countStacks(SuperType.TRAINER, cards)
    }


    override fun showEnergyCards(cards: List<StackedPokemonCard>) {
        adapter.setCards(SuperType.ENERGY, cards)
        cardCount.countStacks(SuperType.ENERGY, cards)
    }


    override fun showDeckName(name: String) {
        if(name.isBlank()) {
            appbar?.setTitle(if (deck == null) R.string.deckbuilder_default_title else R.string.deckbuilder_edit_title)
        }
        else {
            appbar?.title = name
        }
        if (inputDeckName.text.isBlank()) {
            inputDeckName.setText(name)
            inputDeckName.setSelection(name.length)
        }
    }


    override fun showDeckDescription(description: String) {
        if (inputDeckDescription.text.isBlank()) {
            inputDeckDescription.setText(description)
            inputDeckDescription.setSelection(description.length)
        }
    }


    override fun showIsSaving(isSaving: Boolean) {
        invalidateOptionsMenu()
        if (isSaving) {
            if (savingSnackBar == null) {
                savingSnackBar = Snackbar.make(pager, R.string.deckbuilder_saving_message, Snackbar.LENGTH_INDEFINITE)
            }
            else {
                savingSnackBar?.setText(R.string.deckbuilder_saving_message)
                savingSnackBar?.duration = Snackbar.LENGTH_INDEFINITE
            }

            savingSnackBar?.show()
        }
        else {
            if (savingSnackBar == null) {
                savingSnackBar = Snackbar.make(pager, R.string.deckbuilder_saved_message, Snackbar.LENGTH_SHORT)
            }
            else {
                savingSnackBar?.setText(R.string.deckbuilder_saved_message)
                savingSnackBar?.duration = Snackbar.LENGTH_SHORT
            }

            if (savingSnackBar?.isShown == true) {
                savingSnackBar?.show()
            }
        }
    }


    override fun showIsEditing(isEditing: Boolean) {
        invalidateOptionsMenu()
        adapter.isEditing = isEditing
    }


    override fun showError(description: String) {
        snackbar(description)
    }


    override fun showIsStandard(isStandard: Boolean) {
//        formatStandardDetail.setVisible(isStandard)
    }


    override fun showIsExpanded(isExpanded: Boolean) {
//        formatExpandedDetail.setVisible(isExpanded)
    }


    companion object {
        @JvmField val EXTRA_DECK = "com.r0adkll.deckbuilder.intent.EXTRA_DECK"
        @JvmField val EXTRA_IMPORT = "com.r0adkll.deckbuilder.intent.EXTRA_IMPORT"

        fun createIntent(context: Context): Intent = Intent(context, DeckBuilderActivity::class.java)

        fun createIntent(context: Context, deck: Deck): Intent {
            val intent = createIntent(context)
            intent.putExtra(EXTRA_DECK, deck)
            return intent
        }

        fun createIntent(context: Context, import: List<PokemonCard>): Intent {
            val intent = createIntent(context)
            intent.putExtra(EXTRA_IMPORT, ArrayList(import))
            return intent
        }
    }
}