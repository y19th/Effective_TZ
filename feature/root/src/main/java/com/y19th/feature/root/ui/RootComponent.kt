package com.y19th.feature.root.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.childStack
import com.y19th.core.domain.interactors.transition.TransitionInteractor
import com.y19th.core.navigation.navigators.root.RootConfiguration
import com.y19th.core.navigation.navigators.root.RootNavigator
import com.y19th.core.resources.models.Stage
import com.y19th.core.util.extension.EmptyScreen
import com.y19th.dextension.compose.Screen
import com.y19th.dextension.extensions.coroutine.onLimitedDefault
import com.y19th.dextension.extensions.coroutine.withMain
import com.y19th.dextension.koin.components.KoinNavigationComponent
import com.y19th.dextension.koin.getScreen
import com.y19th.feature.authenticate.ui.AuthenticateScreen
import com.y19th.feature.home.root.ui.HomeRootScreen
import com.y19th.feature.root.ui.RootComponent.Child.Authenticate
import com.y19th.feature.root.ui.RootComponent.Child.Home
import com.y19th.feature.root.ui.RootComponent.Child.None

/*
* None конфигурация выступает заместо сплеша
*
* */
internal class RootComponent(
    componentContext: ComponentContext,
    navigator: RootNavigator,
    private val transitionInteractor: TransitionInteractor
) : KoinNavigationComponent(componentContext) {

    val stack = childStack(
        source = navigator.navigation,
        handleBackButton = true,
        initialConfiguration = RootConfiguration.None,
        serializer = RootConfiguration.serializer(),
        childFactory = ::childFactory
    )

    init {
        scope.onLimitedDefault {
            when (transitionInteractor.getStage()) {
                Stage.Authorized -> {
                    withMain { navigator.handleConfiguration(RootConfiguration.Home) }
                }

                Stage.Undefined,
                Stage.NonAuthorized -> {
                    withMain { navigator.handleConfiguration(RootConfiguration.Authenticate) }
                }
            }
        }
    }

    private fun childFactory(
        configuration: RootConfiguration,
        context: ComponentContext
    ): Child = when (configuration) {
        RootConfiguration.Authenticate -> {
            Authenticate(getScreen(context))
        }

        RootConfiguration.Home -> {
            Home(getScreen(context))
        }

        RootConfiguration.None -> {
            None(EmptyScreen(context))
        }
    }

    sealed class Child {
        data class Authenticate(val screen: AuthenticateScreen) : Child()

        data class Home(val screen: HomeRootScreen) : Child()

        data class None(val screen: Screen) : Child()
    }

}