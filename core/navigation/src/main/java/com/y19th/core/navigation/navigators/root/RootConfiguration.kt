package com.y19th.core.navigation.navigators.root

import kotlinx.serialization.Serializable

@Serializable
sealed class RootConfiguration {

    @Serializable
    data object Authenticate : RootConfiguration()

    @Serializable
    data object Home : RootConfiguration()

    @Serializable
    data object None : RootConfiguration()
}