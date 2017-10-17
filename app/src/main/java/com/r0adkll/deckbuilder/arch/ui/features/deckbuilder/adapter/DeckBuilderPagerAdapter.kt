package com.r0adkll.deckbuilder.arch.ui.features.deckbuilder.adapter

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxrelay2.Relay
import com.r0adkll.deckbuilder.R
import com.r0adkll.deckbuilder.arch.domain.features.cards.model.PokemonCard
import io.pokemontcg.model.SuperType


/**
 * Pager adapter for all the [io.pokemontcg.model.SuperType]s involved in building a deck
 */
class DeckBuilderPagerAdapter(
        private val inflater: LayoutInflater,
        private val pokemonCardClicks: Relay<PokemonCard>
) : PagerAdapter() {

    private var pokemonCards: List<PokemonCard> = emptyList()
    private var trainerCards: List<PokemonCard> = emptyList()
    private var energyCards: List<PokemonCard> = emptyList()
    private val viewHolders: Array<SuperTypeViewHolder?> = Array(3, { _ -> null })


    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        val view = inflater.inflate(R.layout.layout_deck_supertype, container, false)
        val vh = SuperTypeViewHolder(view, pokemonCardClicks)
        viewHolders[position] = vh
        view.tag = vh

        vh.bind(when(position) {
            0 -> pokemonCards
            1 -> trainerCards
            else -> energyCards
        })

        container?.addView(view)
        return view
    }


    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        container?.removeView(`object` as View)
    }


    override fun isViewFromObject(view: View?, `object`: Any?): Boolean = view == `object`
    override fun getCount(): Int = 3


    fun setCards(type: SuperType, cards: List<PokemonCard>) {
        when(type) {
            SuperType.POKEMON -> {
                pokemonCards = cards
                viewHolders[0]?.bind(pokemonCards)
            }
            SuperType.TRAINER -> {
                trainerCards = cards
                viewHolders[1]?.bind(trainerCards)
            }
            SuperType.ENERGY -> {
                energyCards = cards
                viewHolders[2]?.bind(energyCards)
            }
        }
    }


}