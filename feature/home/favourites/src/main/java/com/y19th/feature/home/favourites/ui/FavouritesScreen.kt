package com.y19th.feature.home.favourites.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.koin.getComponent
import com.y19th.dextension.koin.KoinScreen
import com.y19th.feature.home.favourites.ui.FavouritesComponent

interface FavouritesScreen : KoinScreen

internal class FavouritesScreenImpl(
    override val componentContext: ComponentContext
) : FavouritesScreen {

    private val component: FavouritesComponent = getComponent(componentContext)

    @Composable
    override fun Content() {
        FavouritesContent(component)
    }
}