package com.y19th.feature.home.root.logic

import com.y19th.core.navigation.navigators.home.HomeConfiguration
import com.y19th.dextension.core.BaseState

internal data class HomeRootState(
    val currentDestination: HomeConfiguration = HomeConfiguration.Main
) : BaseState
