package com.y19th.core.domain.interactors.courses

import com.y19th.core.domain.models.courses.Course
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.flow.Flow

interface CoursesInteractor {

    fun favouriteIntFlow(): Flow<ImmutableList<Int>>

    fun favouriteItemsFlow(): Flow<ImmutableList<Course>>

    suspend fun fetchCourses(): Result<ImmutableList<Course>>

    suspend fun toggleFavourite(item: Course)
}