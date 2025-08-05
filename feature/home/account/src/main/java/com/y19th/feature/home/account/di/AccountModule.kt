package com.y19th.feature.home.account.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import com.y19th.feature.home.account.ui.AccountComponent
import com.y19th.feature.home.account.ui.AccountScreen
import com.y19th.feature.home.account.ui.AccountScreenImpl

val accountModule = module {
    factoryOf(::AccountComponent)
    factoryOf(::AccountScreenImpl).bind<AccountScreen>()
}