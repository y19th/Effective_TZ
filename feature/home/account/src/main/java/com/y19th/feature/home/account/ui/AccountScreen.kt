package com.y19th.feature.home.account.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.koin.getComponent
import com.y19th.dextension.koin.KoinScreen
import com.y19th.feature.home.account.ui.AccountComponent

interface AccountScreen : KoinScreen

internal class AccountScreenImpl(
    override val componentContext: ComponentContext
) : AccountScreen {

    private val component: AccountComponent = getComponent(componentContext)

    @Composable
    override fun Content() {
        AccountContent(component)
    }
}