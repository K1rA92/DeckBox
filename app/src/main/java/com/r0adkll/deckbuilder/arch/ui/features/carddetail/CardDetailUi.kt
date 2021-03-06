package com.r0adkll.deckbuilder.arch.ui.features.carddetail

import android.os.Parcelable
import com.r0adkll.deckbuilder.arch.domain.features.cards.model.PokemonCard
import com.r0adkll.deckbuilder.arch.domain.features.validation.model.Validation
import com.r0adkll.deckbuilder.arch.ui.components.renderers.StateRenderer
import io.reactivex.Observable
import kotlinx.android.parcel.Parcelize


interface CardDetailUi : StateRenderer<CardDetailUi.State> {

    val state: State


    interface Intentions {

        fun addCardClicks(): Observable<Unit>
        fun removeCardClicks(): Observable<Unit>
    }


    interface Actions {

        fun showCopies(count: Int?)
        fun showVariants(cards: List<PokemonCard>)
        fun showEvolvesFrom(cards: List<PokemonCard>)
        fun showEvolvesTo(cards: List<PokemonCard>)
        fun showStandardValidation(isValid: Boolean)
        fun showExpandedValidation(isValid: Boolean)
    }


    @Parcelize
    data class State(
            val sessionId: Long?,
            val card: PokemonCard?,
            val error: String?,
            val count: Int?,
            val variants: List<PokemonCard>,
            val evolvesFrom: List<PokemonCard>,
            val evolvesTo: List<PokemonCard>,
            val validation: Validation
    ) : Parcelable {

        val hasCopies: Boolean
            get() = count?.let { it > 0 } == true


        fun reduce(change: Change): State = when(change) {
            is Change.Error -> this.copy(error = error)
            is Change.CountChanged -> this.copy(count = change.count)
            is Change.Validated -> this.copy(validation = change.validation)
            is Change.VariantsLoaded -> this.copy(variants = change.cards)
            is Change.EvolvesFromLoaded -> this.copy(evolvesFrom = change.cards)
            is Change.EvolvesToLoaded -> this.copy(evolvesTo = change.cards)
        }


        sealed class Change(val logText: String) {
            class Error(val description: String): Change("error -> $description")
            class CountChanged(val count: Int) : Change("user -> number of copies changed $count")
            class VariantsLoaded(val cards: List<PokemonCard>) : Change("network -> variants loaded")
            class EvolvesFromLoaded(val cards: List<PokemonCard>) : Change("network -> evolves from loaded")
            class EvolvesToLoaded(val cards: List<PokemonCard>) : Change("netowrk -> evolves to loaded")
            class Validated(val validation: Validation) : Change("network -> card validated: $validation")
        }


        override fun toString(): String {
            return "State(sessionId=$sessionId, card=${card?.id}, count=$count, variants=${variants.size}, evolvesFrom=${evolvesFrom.size}, evolvesTo=${evolvesTo.size}, validation=$validation"
        }


        companion object {

            val DEFAULT by lazy {
                CardDetailUi.State(null, null, null, null, emptyList(), emptyList(), emptyList(), Validation(false, false, emptyList()))
            }
        }
    }

}