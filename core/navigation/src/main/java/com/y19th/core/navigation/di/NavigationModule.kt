package com.y19th.core.navigation.di

import com.y19th.core.navigation.navigators.root.RootNavigator
import com.y19th.core.navigation.navigators.root.RootNavigatorImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val navigationModule = module {
    singleOf(::RootNavigatorImpl).bind<RootNavigator>()
}