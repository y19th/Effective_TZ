package com.y19th.feature.home.main.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.y19th.core.ui.components.EffectiveText

@Composable
internal fun ErrorContent(
    throwable: Throwable,
    modifier: Modifier = Modifier
) {
    val innerState = rememberUpdatedState(throwable)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        EffectiveText(
            text = "error: ${innerState.value.stackTraceToString()}"
        )
    }
}