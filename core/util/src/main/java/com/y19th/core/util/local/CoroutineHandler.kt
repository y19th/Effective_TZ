@file:Suppress("FunctionName")

package com.y19th.core.util.local

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

private const val handlerTag = "CaughtCoroutineException"

val baseCoroutineHandler = screenCoroutineExceptionHandler("BaseHandler")

fun screenCoroutineExceptionHandler(tag: String?): CoroutineExceptionHandler =
    ScreenCoroutineExceptionHandler { throwable ->
        message(handlerTag, "---------------CAUGHT---------------", LoggerLevel.Error)
        message(handlerTag, "[caught on $tag component]", LoggerLevel.Error)
        message(
            handlerTag,
            "caught: ${throwable.stackTraceToString()}", LoggerLevel.Error
        )
        message(handlerTag, "-------------END_CAUGHT-------------", LoggerLevel.Error)
    }

private inline fun ScreenCoroutineExceptionHandler(
    crossinline handler: (exception: Throwable) -> Unit
): CoroutineExceptionHandler =
    object : AbstractCoroutineContextElement(CoroutineExceptionHandler), CoroutineExceptionHandler {
        override fun handleException(context: CoroutineContext, exception: Throwable) =
            handler(exception)
    }
