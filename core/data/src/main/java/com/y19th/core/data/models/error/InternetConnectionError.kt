package com.y19th.core.data.models.error

internal class InternetConnectionError: Throwable() {
    override val message: String?
        get() = "Internet connection error"
}


