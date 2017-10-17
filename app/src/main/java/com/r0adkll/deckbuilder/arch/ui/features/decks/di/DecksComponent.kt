package com.r0adkll.deckbuilder.arch.ui.features.decks.di


import com.r0adkll.deckbuilder.arch.ui.features.decks.DecksFragment
import com.r0adkll.deckbuilder.internal.di.FragmentScope
import dagger.Subcomponent


@FragmentScope
@Subcomponent(modules = arrayOf(DecksModule::class))
interface DecksComponent {

    fun inject(fragment: DecksFragment)
}