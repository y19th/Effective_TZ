package com.y19th.feature.home.main.logic

import com.y19th.core.domain.models.courses.Course
import com.y19th.dextension.core.BaseState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

internal sealed interface MainState : BaseState {

    data object Loading : MainState

    data class Success(val courses: ImmutableList<Course> = persistentListOf()) : MainState

    data class Error(val error: Throwable) : MainState
}