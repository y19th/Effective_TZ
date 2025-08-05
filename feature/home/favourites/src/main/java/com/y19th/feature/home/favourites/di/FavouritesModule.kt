package com.y19th.feature.home.favourites.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import com.y19th.feature.home.favourites.ui.FavouritesComponent
import com.y19th.feature.home.favourites.ui.FavouritesScreen
import com.y19th.feature.home.favourites.ui.FavouritesScreenImpl

val favouritesModule = module {
    factoryOf(::FavouritesComponent)
    factoryOf(::FavouritesScreenImpl).bind<FavouritesScreen>()
}