package com.y19th.core.domain.interactors.courses

import com.y19th.core.domain.models.courses.Course
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.flow.Flow

interface CoursesInteractor {

    fun favouriteFlow(): Flow<ImmutableList<Int>>

    suspend fun fetchCourses(): Result<ImmutableList<Course>>

    suspend fun toggleFavourite(item: Course)
}