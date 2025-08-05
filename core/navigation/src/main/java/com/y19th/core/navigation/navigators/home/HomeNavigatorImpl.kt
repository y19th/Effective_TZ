package com.y19th.core.navigation.navigators.home

import com.arkivanov.decompose.router.stack.bringToFront
import com.y19th.core.navigation.navigators.default.DefaultNavigator

internal class HomeNavigatorImpl : DefaultNavigator<HomeConfiguration>(), HomeNavigator {

    override fun handleConfiguration(configuration: HomeConfiguration) {
        navigation.bringToFront(configuration)
    }
}