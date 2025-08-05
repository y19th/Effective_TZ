package com.y19th.core.domain.repository.courses

import com.y19th.core.domain.models.courses.Course

interface DataCoursesRepository {

    suspend fun fetchCourses(): Result<List<Course>>
}