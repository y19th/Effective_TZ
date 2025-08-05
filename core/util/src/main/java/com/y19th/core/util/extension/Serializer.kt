package com.y19th.core.util.extension

import kotlinx.serialization.json.Json

inline fun <reified T> T.encode(): String {
    return Json.encodeToString(this)
}

inline fun <reified T> String.decode(): T {
    return Json.decodeFromString(this)
}
