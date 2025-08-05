package com.y19th.core.navigation.navigators.home

import kotlinx.serialization.Serializable

@Serializable
sealed class HomeConfiguration {

    @Serializable
    data object Main : HomeConfiguration()

    @Serializable
    data object Favourites : HomeConfiguration()

    @Serializable
    data object Account : HomeConfiguration()
}