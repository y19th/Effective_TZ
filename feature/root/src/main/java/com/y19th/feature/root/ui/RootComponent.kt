package com.y19th.feature.root.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.childStack
import com.y19th.core.navigation.navigators.root.RootConfiguration
import com.y19th.core.navigation.navigators.root.RootNavigator
import com.y19th.dextension.compose.Screen
import com.y19th.dextension.koin.components.KoinNavigationComponent
import com.y19th.dextension.koin.getScreen
import com.y19th.feature.authenticate.ui.AuthenticateScreen

internal class RootComponent(
    componentContext: ComponentContext,
    navigator: RootNavigator
) : KoinNavigationComponent(componentContext) {

    val stack = childStack(
        source = navigator.navigation,
        handleBackButton = true,
        initialConfiguration = RootConfiguration.Authenticate,
        serializer = RootConfiguration.serializer(),
        childFactory = ::childFactory
    )

    private fun childFactory(
        configuration: RootConfiguration,
        context: ComponentContext
    ): Child = when (configuration) {
        RootConfiguration.Authenticate -> {
            Child.Authenticate(getScreen(context))
        }

        RootConfiguration.Home -> {
            Child.Home(getScreen(context))
        }
    }

    sealed class Child {
        data class Authenticate(val screen: AuthenticateScreen) : Child()

        data class Home(val screen: Screen) : Child()
    }

}