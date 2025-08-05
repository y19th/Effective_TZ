package com.y19th.feature.home.ui

import com.arkivanov.decompose.ComponentContext
import com.y19th.feature.home.logic.HomeState
import com.y19th.feature.home.logic.HomeEvents
import com.y19th.dextension.core.ScreenComponent

internal class HomeComponent(
    componentContext: ComponentContext
): ScreenComponent<HomeState, HomeEvents>(
    componentContext = componentContext,
    initialState = HomeState()
){
    override fun handleEvent(event: HomeEvents) {
        when(event) {
            HomeEvents.OnNavigateBack -> {
                TODO()
            }
        }
    }
}