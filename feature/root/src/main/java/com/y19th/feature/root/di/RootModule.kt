package com.y19th.feature.root.di

import com.y19th.feature.authenticate.di.authenticateModule
import com.y19th.feature.home.root.di.homeRootModule
import com.y19th.feature.root.ui.RootComponent
import com.y19th.feature.root.ui.RootScreen
import com.y19th.feature.root.ui.RootScreenImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val rootModule = module {
    includes(authenticateModule, homeRootModule)
    factoryOf(::RootComponent)
    factoryOf(::RootScreenImpl).bind<RootScreen>()
}