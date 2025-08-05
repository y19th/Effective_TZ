package com.y19th.core.domain.interactors.base

import com.y19th.core.util.local.screenCoroutineExceptionHandler
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent

internal abstract class BaseInteractor(
    dispatcher: CoroutineDispatcher = Dispatchers.Default
): KoinComponent {
    private val tag = this::class.simpleName ?: "BaseRepository"
    protected val context = screenCoroutineExceptionHandler(tag) + dispatcher

    protected suspend fun <T> changeContext(block: suspend CoroutineScope.() -> T) =
        withContext(context, block)
}