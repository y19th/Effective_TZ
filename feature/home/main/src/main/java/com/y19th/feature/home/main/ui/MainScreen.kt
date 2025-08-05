package com.y19th.feature.home.main.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.koin.getComponent
import com.y19th.dextension.koin.KoinScreen

interface MainScreen : KoinScreen

internal class MainScreenImpl(
    override val componentContext: ComponentContext
) : MainScreen {

    private val component: MainComponent = getComponent(componentContext)

    @Composable
    override fun Content() {
        MainContent(component)
    }
}