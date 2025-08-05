package com.y19th.core.data.extension

import com.y19th.core.data.models.error.InternetConnectionError
import com.y19th.core.data.models.error.ServerConnectionError
import retrofit2.Response

internal fun <T> Response<T>.toResult(): Result<T> {
    return if (isSuccessful)
        Result.success(requireNotNull(body()))
    else
        Result.failure(
            when (code()) {
                400 -> InternetConnectionError()
                //....
                else -> ServerConnectionError()
            }
        )
}