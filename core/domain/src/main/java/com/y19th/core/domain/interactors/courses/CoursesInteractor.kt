package com.y19th.core.domain.interactors.courses

import com.y19th.core.domain.models.courses.Course
import kotlinx.collections.immutable.ImmutableList

interface CoursesInteractor {

    suspend fun fetchCourses(): Result<ImmutableList<Course>>
}