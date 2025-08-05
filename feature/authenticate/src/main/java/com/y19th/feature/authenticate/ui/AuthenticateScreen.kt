package com.y19th.feature.authenticate.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.koin.getComponent
import com.y19th.dextension.koin.KoinScreen
import com.y19th.feature.authenticate.ui.AuthenticateComponent

interface AuthenticateScreen : KoinScreen

internal class AuthenticateScreenImpl(
    override val componentContext: ComponentContext
) : AuthenticateScreen {

    private val component: AuthenticateComponent = getComponent(componentContext)

    @Composable
    override fun Content() {
        AuthenticateContent(component)
    }
}