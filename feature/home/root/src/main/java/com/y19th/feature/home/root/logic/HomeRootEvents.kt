package com.y19th.feature.home.root.logic

import com.y19th.dextension.core.BaseEvents

internal sealed interface HomeRootEvents : BaseEvents {

    data object OnMainScreen: HomeRootEvents

    data object OnFavouritesScreen: HomeRootEvents

    data object OnAccountScreen: HomeRootEvents
}