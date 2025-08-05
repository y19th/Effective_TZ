package com.y19th.feature.authenticate.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import com.y19th.feature.authenticate.ui.AuthenticateComponent
import com.y19th.feature.authenticate.ui.AuthenticateScreen
import com.y19th.feature.authenticate.ui.AuthenticateScreenImpl

val authenticateModule = module {
    factoryOf(::AuthenticateComponent)
    factoryOf(::AuthenticateScreenImpl).bind<AuthenticateScreen>()
}