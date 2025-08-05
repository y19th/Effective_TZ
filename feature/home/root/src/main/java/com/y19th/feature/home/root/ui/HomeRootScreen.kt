package com.y19th.feature.home.root.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.koin.KoinScreen
import com.y19th.dextension.koin.getComponent

interface HomeRootScreen : KoinScreen

internal class HomeRootScreenImpl(
    override val componentContext: ComponentContext
) : HomeRootScreen {

    private val component: HomeRootComponent = getComponent(componentContext)

    @Composable
    override fun Content() {
        RootContent(component)
    }
}