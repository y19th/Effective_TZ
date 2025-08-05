package com.y19th.feature.home.main.ui

import com.arkivanov.decompose.ComponentContext
import com.y19th.feature.home.main.logic.MainState
import com.y19th.feature.home.main.logic.MainEvents
import com.y19th.dextension.core.ScreenComponent

internal class MainComponent(
    componentContext: ComponentContext
): ScreenComponent<MainState, MainEvents>(
    componentContext = componentContext,
    initialState = MainState()
){
    override fun handleEvent(event: MainEvents) {
        when(event) {
            MainEvents.OnNavigateBack -> {
                TODO()
            }
        }
    }
}