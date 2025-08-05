package com.y19th.core.local.repository

import com.y19th.core.domain.models.courses.Course
import com.y19th.core.domain.repository.courses.LocalCoursesRepository
import com.y19th.core.local.dao.CourseDao
import com.y19th.core.local.mapper.toCourse
import com.y19th.core.local.mapper.toCourseEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class LocalCourseRepositoryImpl(
    private val dao: CourseDao
) : LocalCoursesRepository {

    override fun flow(): Flow<List<Int>> =
        dao.courseIdsFlow()

    override fun itemsFlow(): Flow<List<Course>> =
        dao.courseItemsFlow()
            .map { it.map { item -> item.toCourse() } }

    override suspend fun pushFavourite(item: Course) {
        dao.insert(item.toCourseEntity())
    }

    override suspend fun toggleFavourite(item: Course) {
        if (dao.takeAll().find { it.id == item.id } != null)
            dao.deleteItem(item.id)
        else
            dao.insert(
                item
                    .copy(hasLike = true)
                    .toCourseEntity()
            )
    }

    override suspend fun takeAll(): List<Course> {
        return dao.takeAll().map { it.toCourse() }
    }
}