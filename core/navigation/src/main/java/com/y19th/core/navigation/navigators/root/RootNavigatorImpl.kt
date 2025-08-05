package com.y19th.core.navigation.navigators.root

import com.arkivanov.decompose.router.stack.navigate
import com.y19th.core.navigation.navigators.default.DefaultNavigator

internal class RootNavigatorImpl : DefaultNavigator<RootConfiguration>(), RootNavigator {

    override fun handleConfiguration(configuration: RootConfiguration) {
        navigation.navigate { listOf(configuration) }
    }
}