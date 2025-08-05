package com.y19th.core.domain.interactors.courses

import com.y19th.core.domain.interactors.base.BaseInteractor
import com.y19th.core.domain.models.courses.Course
import com.y19th.core.domain.repository.courses.DataCoursesRepository
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

internal class CoursesInteractorImpl(
    private val dataCoursesRepository: DataCoursesRepository
) : CoursesInteractor, BaseInteractor() {

    override suspend fun fetchCourses(): Result<ImmutableList<Course>> = changeContext {
        dataCoursesRepository.fetchCourses().mapCatching { it.toImmutableList() }
    }
}