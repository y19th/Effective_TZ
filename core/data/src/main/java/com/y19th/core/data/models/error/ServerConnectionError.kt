package com.y19th.core.data.models.error

internal class ServerConnectionError : Throwable() {
    override val message: String?
        get() = "Server is unavailable now"
}