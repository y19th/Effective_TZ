package com.y19th.core.data.network

import com.y19th.core.data.models.courses.CoursesResponse
import retrofit2.Response
import retrofit2.http.GET

internal interface MainApi {

    @GET(COURSES_URL)
    suspend fun fetchCourses(): Response<CoursesResponse>
}