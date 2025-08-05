package com.y19th.core.navigation.navigators.default

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.y19th.dextension.core.BaseNavigator

internal abstract class DefaultNavigator<C : Any> : BaseNavigator<C> {

    override val navigation: StackNavigation<C> = StackNavigation()
    override fun handleConfiguration(configuration: C) = navigation.bringToFront(configuration)
}