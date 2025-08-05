package com.y19th.feature.home.favourites.ui

import androidx.compose.runtime.Composable
import com.y19th.dextension.compose.collectAsImmediateState
import com.y19th.dextension.compose.rememberHandleEvents

@Composable
internal fun FavouritesContent(
    component: FavouritesComponent
) { 
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()                
}