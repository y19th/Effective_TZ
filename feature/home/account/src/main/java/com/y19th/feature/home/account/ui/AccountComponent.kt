package com.y19th.feature.home.account.ui

import com.arkivanov.decompose.ComponentContext
import com.y19th.core.domain.interactors.transition.TransitionInteractor
import com.y19th.core.navigation.navigators.root.RootConfiguration
import com.y19th.core.navigation.navigators.root.RootNavigator
import com.y19th.core.resources.models.Stage
import com.y19th.dextension.core.EventComponent
import com.y19th.dextension.extensions.coroutine.onLimitedDefault
import com.y19th.dextension.extensions.coroutine.withMain
import com.y19th.feature.home.account.logic.AccountEvents

internal class AccountComponent(
    componentContext: ComponentContext,
    private val rootNavigator: RootNavigator,
    private val transitionInteractor: TransitionInteractor
): EventComponent<AccountEvents>(
    componentContext = componentContext
){
    override fun handleEvent(event: AccountEvents) {
        when(event) {
            AccountEvents.OnNavigateBack -> {
                scope.onLimitedDefault {
                    transitionInteractor.update(Stage.NonAuthorized)
                    withMain { rootNavigator.handleConfiguration(RootConfiguration.Authenticate) }
                }
            }
        }
    }
}