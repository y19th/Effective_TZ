package com.y19th.core.domain.interactors.courses

import com.y19th.core.domain.interactors.base.BaseInteractor
import com.y19th.core.domain.models.courses.Course
import com.y19th.core.domain.repository.courses.DataCoursesRepository
import com.y19th.core.domain.repository.courses.LocalCoursesRepository
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

internal class CoursesInteractorImpl(
    private val dataCoursesRepository: DataCoursesRepository,
    private val localCoursesRepository: LocalCoursesRepository
) : CoursesInteractor, BaseInteractor() {

    override fun favouriteFlow(): Flow<ImmutableList<Int>> =
        localCoursesRepository.flow()
            .map { it.toImmutableList() }
            .flowOn(context)

    override suspend fun fetchCourses(): Result<ImmutableList<Course>> = changeContext {
        dataCoursesRepository.fetchCourses().mapCatching { it.toImmutableList() }
    }

    override suspend fun toggleFavourite(item: Course) {
        localCoursesRepository.toggleFavourite(item)
    }
}