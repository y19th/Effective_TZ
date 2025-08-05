package com.y19th.core.data.models.courses

import com.y19th.core.data.models.Transformable
import com.y19th.core.domain.models.courses.Course
import kotlinx.serialization.Serializable

@Serializable
internal data class CoursesItemResponse(
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val hasLike: Boolean,
    val publishDate: String
) : Transformable<Course> {
    override fun transform(): Course {
        return Course(
            id = id,
            title = title,
            text = text,
            price = price,
            rate = rate,
            startDate = startDate,
            hasLike = hasLike,
            publishDate = publishDate
        )
    }
}
