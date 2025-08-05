package com.y19th.core.data.models.courses

import kotlinx.serialization.Serializable

@Serializable
internal data class CoursesResponse(
    val courses: List<CoursesItemResponse>
)
