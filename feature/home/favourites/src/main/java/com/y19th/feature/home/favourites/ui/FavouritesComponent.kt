package com.y19th.feature.home.favourites.ui

import com.arkivanov.decompose.ComponentContext
import com.y19th.core.domain.interactors.courses.CoursesInteractor
import com.y19th.core.util.extension.launchLifecycle
import com.y19th.dextension.core.ScreenComponent
import com.y19th.dextension.extensions.coroutine.onDefaultDispatcher
import com.y19th.dextension.extensions.coroutine.onLimitedDefault
import com.y19th.feature.home.favourites.logic.FavouritesEvents
import com.y19th.feature.home.favourites.logic.FavouritesState

internal class FavouritesComponent(
    componentContext: ComponentContext,
    private val coursesInteractor: CoursesInteractor
) : ScreenComponent<FavouritesState, FavouritesEvents>(
    componentContext = componentContext,
    initialState = FavouritesState.Loading
) {
    init {
        coursesInteractor.favouriteItemsFlow()
            .onDefaultDispatcher { items ->
                if (items.isNotEmpty())
                    update { FavouritesState.Success(items = items) }
                else
                    update { FavouritesState.Empty }
            }
            .launchLifecycle(this)
    }

    override fun handleEvent(event: FavouritesEvents) {
        when (event) {
            is FavouritesEvents.OnToggleFavourite -> {
                scope.onLimitedDefault {
                    coursesInteractor.toggleFavourite(event.item)
                }
            }
        }
    }
}