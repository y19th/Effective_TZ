package com.y19th.feature.home.root.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.childStack
import com.y19th.core.navigation.navigators.home.HomeConfiguration
import com.y19th.core.navigation.navigators.home.HomeNavigator
import com.y19th.dextension.koin.components.KoinScreenComponent
import com.y19th.dextension.koin.getScreen
import com.y19th.feature.home.account.ui.AccountScreen
import com.y19th.feature.home.favourites.ui.FavouritesScreen
import com.y19th.feature.home.main.ui.MainScreen
import com.y19th.feature.home.root.logic.HomeRootEvents
import com.y19th.feature.home.root.logic.HomeRootState

internal class HomeRootComponent(
    componentContext: ComponentContext,
    private val navigator: HomeNavigator
) : KoinScreenComponent<HomeRootState, HomeRootEvents>(
    componentContext = componentContext,
    initialState = HomeRootState()
) {

    val stack = childStack(
        source = navigator.navigation,
        handleBackButton = true,
        initialConfiguration = HomeConfiguration.Main,
        serializer = HomeConfiguration.serializer(),
        childFactory = ::childFactory
    )

    private fun childFactory(
        configuration: HomeConfiguration,
        context: ComponentContext
    ): Child = when (configuration) {
        HomeConfiguration.Account -> {
            Child.Account(getScreen(context))
        }

        HomeConfiguration.Favourites -> {
            Child.Favourites(getScreen(context))
        }

        HomeConfiguration.Main -> {
            Child.Main(getScreen(context))
        }
    }

    sealed class Child {

        data class Main(val screen: MainScreen) : Child()

        data class Favourites(val screen: FavouritesScreen) : Child()

        data class Account(val screen: AccountScreen) : Child()
    }

    override fun handleEvent(event: HomeRootEvents) {
        when (event) {
            HomeRootEvents.OnAccountScreen -> {
                navigator.handleConfiguration(HomeConfiguration.Account)
                update { copy(currentDestination = HomeConfiguration.Account) }
            }

            HomeRootEvents.OnFavouritesScreen -> {
                navigator.handleConfiguration(HomeConfiguration.Favourites)
                update { copy(currentDestination = HomeConfiguration.Favourites) }
            }

            HomeRootEvents.OnMainScreen -> {
                navigator.handleConfiguration(HomeConfiguration.Main)
                update { copy(currentDestination = HomeConfiguration.Main) }
            }
        }
    }

}