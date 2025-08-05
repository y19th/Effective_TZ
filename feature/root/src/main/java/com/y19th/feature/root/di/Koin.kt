package com.y19th.feature.root.di

import com.y19th.core.navigation.di.navigationModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initKoin(additionalModules: Module): KoinApplication {
    return startKoin {
        modules(
            additionalModules,
            navigationModule,
            rootModule
        )
    }
}
