package com.r0adkll.deckbuilder.arch.ui.features.search.adapter


import android.content.Context
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import com.r0adkll.deckbuilder.arch.domain.features.cards.model.PokemonCard
import com.r0adkll.deckbuilder.arch.ui.components.ListRecyclerAdapter
import com.r0adkll.deckbuilder.arch.ui.components.RecyclerViewBinding


class SearchResultsRecyclerAdapter(
        context: Context
) : ListRecyclerAdapter<PokemonCard, PokemonCardViewHolder>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonCardViewHolder {
        return PokemonCardViewHolder.create(inflater, parent)
    }


    override fun onBindViewHolder(vh: PokemonCardViewHolder, i: Int) {
        super.onBindViewHolder(vh, i)
        vh.bind(items[i])
    }


    fun setCards(cards: List<PokemonCard>) {
        val diff = calculateDiff(items, cards)
        items = ArrayList(diff.new)
        diff.diff.dispatchUpdatesTo(DiffUpdateCallback())
    }


    companion object {
        private fun calculateDiff(old: List<PokemonCard>, new: List<PokemonCard>): RecyclerViewBinding<PokemonCard> {
            val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    val oldItem = old[oldItemPosition]
                    val newItem = new[newItemPosition]
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    val oldItem = old[oldItemPosition]
                    val newItem = new[newItemPosition]
                    return oldItem == newItem
                }

                override fun getOldListSize(): Int = old.size
                override fun getNewListSize(): Int = new.size
            })

            return RecyclerViewBinding(new = new, diff = diff)
        }
    }
}