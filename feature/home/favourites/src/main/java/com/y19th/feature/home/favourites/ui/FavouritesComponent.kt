package com.y19th.feature.home.favourites.ui

import com.arkivanov.decompose.ComponentContext
import com.y19th.feature.home.favourites.logic.FavouritesState
import com.y19th.feature.home.favourites.logic.FavouritesEvents
import com.y19th.dextension.core.ScreenComponent

internal class FavouritesComponent(
    componentContext: ComponentContext
): ScreenComponent<FavouritesState, FavouritesEvents>(
    componentContext = componentContext,
    initialState = FavouritesState()
){
    override fun handleEvent(event: FavouritesEvents) {
        when(event) {
            FavouritesEvents.OnNavigateBack -> {
                TODO()
            }
        }
    }
}