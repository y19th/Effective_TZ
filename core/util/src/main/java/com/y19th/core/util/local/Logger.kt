package com.y19th.core.util.local

import co.touchlab.kermit.Logger

object LogSupporter {
    var debug: Boolean = true
}

fun debugMessage(
    message: String,
    tag: String = "Debug",
    level: LoggerLevel = LoggerLevel.Debug
) {
    if (LogSupporter.debug)
        message(tag, message, level)
}

fun message(
    tag: String,
    message: String,
    level: LoggerLevel = LoggerLevel.Debug,
    throwable: Throwable? = null
) {
    if (LogSupporter.debug)
        when (level) {
            LoggerLevel.Assert -> {
                Logger.a(
                    tag,
                    throwable
                ) { message }
            }

            LoggerLevel.Debug -> {
                Logger.d(
                    tag,
                    throwable
                ) { message }
            }

            LoggerLevel.Error -> {
                Logger.e(
                    tag,
                    throwable
                ) { message }
            }

            LoggerLevel.Info -> {
                Logger.i(
                    tag,
                    throwable
                ) { message }
            }

            LoggerLevel.Verbose -> {
                Logger.v(
                    tag,
                    throwable
                ) { message }
            }

            LoggerLevel.Warning -> {
                Logger.w(
                    tag,
                    throwable
                ) { message }
            }
        }
}

sealed interface LoggerLevel {

    data object Verbose : LoggerLevel

    data object Debug : LoggerLevel

    data object Info : LoggerLevel

    data object Warning : LoggerLevel

    data object Error : LoggerLevel

    data object Assert : LoggerLevel
}
