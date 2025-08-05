package com.y19th.feature.home.main.ui

import com.arkivanov.decompose.ComponentContext
import com.y19th.core.domain.interactors.courses.CoursesInteractor
import com.y19th.dextension.core.ScreenComponent
import com.y19th.dextension.extensions.coroutine.onLimitedDefault
import com.y19th.feature.home.main.logic.MainEvents
import com.y19th.feature.home.main.logic.MainState

internal class MainComponent(
    componentContext: ComponentContext,
    private val coursesInteractor: CoursesInteractor
) : ScreenComponent<MainState, MainEvents>(
    componentContext = componentContext,
    initialState = MainState.Loading
) {
    init {
        scope.onLimitedDefault {
            coursesInteractor.fetchCourses()
                .onSuccess {
                    update {
                        MainState.Success(it)
                    }
                }
                .onFailure {
                    //...
                    update {
                        MainState.Error(it)
                    }
                    message(it.stackTraceToString())
                }
        }
    }

    override fun handleEvent(event: MainEvents) {
        when (event) {
            MainEvents.OnDateFilterClick -> {

            }
        }
    }
}