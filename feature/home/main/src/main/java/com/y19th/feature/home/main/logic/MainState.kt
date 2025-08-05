package com.y19th.feature.home.main.logic

import com.y19th.core.domain.models.courses.Course
import com.y19th.dextension.core.BaseState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

internal data class MainState(
    val courses: ImmutableList<Course> = persistentListOf(),
    val favourites: ImmutableList<Int> = persistentListOf(),

    val isLoading: Boolean = true,
    val error: Throwable? = null
): BaseState