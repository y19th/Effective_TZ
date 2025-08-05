package com.y19th.feature.home.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.koin.getComponent
import com.y19th.dextension.koin.KoinScreen
import com.y19th.feature.home.ui.HomeComponent

interface HomeScreen : KoinScreen

internal class HomeScreenImpl(
    override val componentContext: ComponentContext
) : HomeScreen {

    private val component: HomeComponent = getComponent(componentContext)

    @Composable
    override fun Content() {
        HomeContent(component)
    }
}