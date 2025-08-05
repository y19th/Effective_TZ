package com.y19th.core.data.repository

import com.y19th.core.data.extension.toResult
import com.y19th.core.data.network.MainApi
import com.y19th.core.domain.models.courses.Course
import com.y19th.core.domain.repository.courses.DataCoursesRepository

internal class DataCoursesRepositoryImpl(
    private val api: MainApi
) : DataCoursesRepository {

    override suspend fun fetchCourses(): Result<List<Course>> =
        api.fetchCourses().toResult()
            .mapCatching { it.courses.map { course -> course.transform() } }

}