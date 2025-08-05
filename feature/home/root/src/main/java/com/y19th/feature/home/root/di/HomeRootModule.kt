package com.y19th.feature.home.root.di

import com.y19th.feature.home.account.di.accountModule
import com.y19th.feature.home.favourites.di.favouritesModule
import com.y19th.feature.home.main.di.mainModule
import com.y19th.feature.home.root.ui.HomeRootComponent
import com.y19th.feature.home.root.ui.HomeRootScreen
import com.y19th.feature.home.root.ui.HomeRootScreenImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val homeRootModule = module {
    includes(mainModule, favouritesModule, accountModule)
    factoryOf(::HomeRootComponent)
    factoryOf(::HomeRootScreenImpl).bind<HomeRootScreen>()
}