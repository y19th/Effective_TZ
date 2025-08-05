package com.y19th.feature.home.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import com.y19th.feature.home.ui.HomeComponent
import com.y19th.feature.home.ui.HomeScreen
import com.y19th.feature.home.ui.HomeScreenImpl

val homeModule = module {
    factoryOf(::HomeComponent)
    factoryOf(::HomeScreenImpl).bind<HomeScreen>()
}