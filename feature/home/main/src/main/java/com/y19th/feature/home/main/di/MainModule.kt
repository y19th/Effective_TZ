package com.y19th.feature.home.main.di

import com.y19th.feature.home.main.ui.MainComponent
import com.y19th.feature.home.main.ui.MainScreen
import com.y19th.feature.home.main.ui.MainScreenImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val mainModule = module {
    factoryOf(::MainComponent)
    factoryOf(::MainScreenImpl).bind<MainScreen>()
}