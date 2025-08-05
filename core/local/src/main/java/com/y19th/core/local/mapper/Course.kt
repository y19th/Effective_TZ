package com.y19th.core.local.mapper

import com.y19th.core.domain.models.courses.Course
import com.y19th.core.local.entities.CourseEntity

internal fun Course.toCourseEntity() = CourseEntity(
    id = id,
    title = title,
    text = text,
    price = price,
    rate = rate,
    startDate = startDate,
    hasLike = hasLike,
    publishDate = publishDate
)

internal fun CourseEntity.toCourse() = Course(
    id = id,
    title = title,
    text = text,
    price = price,
    rate = rate,
    startDate = startDate,
    hasLike = hasLike,
    publishDate = publishDate
)