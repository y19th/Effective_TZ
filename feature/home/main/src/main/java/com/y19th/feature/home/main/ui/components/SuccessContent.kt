package com.y19th.feature.home.main.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import com.y19th.core.ui.components.EffectiveText
import com.y19th.feature.home.main.logic.MainState

@Composable
internal fun SuccessContent(
    state: MainState.Success,
    modifier: Modifier = Modifier
) {
    val innerState = rememberUpdatedState(state)

    EffectiveText(
        text = innerState.value.courses.joinToString()
    )
}