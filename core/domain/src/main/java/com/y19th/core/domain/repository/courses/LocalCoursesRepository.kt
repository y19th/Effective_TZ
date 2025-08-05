package com.y19th.core.domain.repository.courses

import com.y19th.core.domain.models.courses.Course
import kotlinx.coroutines.flow.Flow

interface LocalCoursesRepository {

    fun flow(): Flow<List<Int>>

    fun itemsFlow(): Flow<List<Course>>

    suspend fun toggleFavourite(item: Course)

    suspend fun takeAll(): List<Course>
}