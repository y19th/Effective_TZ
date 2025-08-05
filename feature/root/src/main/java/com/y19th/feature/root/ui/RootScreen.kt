package com.y19th.feature.root.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.koin.getComponent
import com.y19th.dextension.koin.KoinScreen

interface RootScreen : KoinScreen

internal class RootScreenImpl(
    override val componentContext: ComponentContext
) : RootScreen {

    private val component: RootComponent = getComponent(componentContext)

    @Composable
    override fun Content() {
        RootContent(component)
    }
}