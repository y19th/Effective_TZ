package com.y19th.feature.home.account.ui

import com.arkivanov.decompose.ComponentContext
import com.y19th.feature.home.account.logic.AccountState
import com.y19th.feature.home.account.logic.AccountEvents
import com.y19th.dextension.core.ScreenComponent

internal class AccountComponent(
    componentContext: ComponentContext
): ScreenComponent<AccountState, AccountEvents>(
    componentContext = componentContext,
    initialState = AccountState()
){
    override fun handleEvent(event: AccountEvents) {
        when(event) {
            AccountEvents.OnNavigateBack -> {
                TODO()
            }
        }
    }
}