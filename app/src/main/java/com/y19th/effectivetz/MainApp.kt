package com.y19th.effectivetz

import android.app.Application
import android.content.Context
import com.y19th.feature.root.di.initKoin
import org.koin.dsl.module

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin(
            additionalModules = module {
                single<Context> { this@MainApp }
            }
        )
    }
}