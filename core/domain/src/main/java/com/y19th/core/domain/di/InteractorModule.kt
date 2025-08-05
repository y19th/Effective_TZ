package com.y19th.core.domain.di

import com.y19th.core.domain.interactors.transition.TransitionInteractor
import com.y19th.core.domain.interactors.transition.TransitionInteractorImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::TransitionInteractorImpl).bind<TransitionInteractor>()
}