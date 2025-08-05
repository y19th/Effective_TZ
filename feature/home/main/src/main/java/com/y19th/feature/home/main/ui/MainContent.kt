package com.y19th.feature.home.main.ui

import androidx.compose.runtime.Composable
import com.y19th.core.ui.components.EffectiveColumn
import com.y19th.dextension.compose.collectAsImmediateState
import com.y19th.dextension.compose.rememberHandleEvents
import com.y19th.feature.home.main.logic.MainState
import com.y19th.feature.home.main.ui.components.ErrorContent
import com.y19th.feature.home.main.ui.components.LoadingContent
import com.y19th.feature.home.main.ui.components.SuccessContent

@Composable
internal fun MainContent(
    component: MainComponent
) {
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()

    EffectiveColumn {
        when (val innerState = state.value) {
            is MainState.Error -> {
                ErrorContent(innerState)
            }

            MainState.Loading -> {
                LoadingContent()
            }

            is MainState.Success -> {
                SuccessContent(innerState)
            }
        }
    }
}