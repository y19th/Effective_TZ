package com.y19th.feature.home.main.ui

import com.arkivanov.decompose.ComponentContext
import com.y19th.core.domain.interactors.courses.CoursesInteractor
import com.y19th.core.domain.models.courses.Course
import com.y19th.core.util.extension.launchLifecycle
import com.y19th.dextension.core.ScreenComponent
import com.y19th.dextension.extensions.coroutine.onDefaultDispatcher
import com.y19th.dextension.extensions.coroutine.onLimitedDefault
import com.y19th.feature.home.main.logic.MainEvents
import com.y19th.feature.home.main.logic.MainState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

internal class MainComponent(
    componentContext: ComponentContext,
    private val coursesInteractor: CoursesInteractor
) : ScreenComponent<MainState, MainEvents>(
    componentContext = componentContext,
    initialState = MainState()
) {
    init {
        coursesInteractor.favouriteFlow()
            .onDefaultDispatcher { favourite ->
                update {
                    copy(
                        courses = courses.mapByFavourites(favourite),
                        favourites = favourite
                    )
                }
            }
            .launchLifecycle(this)

        scope.onLimitedDefault {
            coursesInteractor.fetchCourses()
                .onSuccess {
                    update {
                        copy(
                            courses = it.mapByFavourites(favourites),
                            isLoading = false
                        )
                    }
                }
                .onFailure {
                    //...
                    update {
                        copy(error = it)
                    }
                    message(it.stackTraceToString())
                }
        }
    }

    override fun handleEvent(event: MainEvents) {
        when (event) {
            MainEvents.OnDateFilterClick -> {

            }

            is MainEvents.OnFavouriteIconClick -> {
                scope.onLimitedDefault {
                    coursesInteractor.toggleFavourite(event.item)
                }
            }
        }
    }

    private fun ImmutableList<Course>.mapByFavourites(favourites: ImmutableList<Int>): ImmutableList<Course> =
        this
            .map { item ->
                item.copy(hasLike = favourites.contains(item.id))
            }
            .toImmutableList()
}