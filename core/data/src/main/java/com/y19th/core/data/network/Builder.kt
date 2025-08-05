package com.y19th.core.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal fun retrofitBuilder() = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()