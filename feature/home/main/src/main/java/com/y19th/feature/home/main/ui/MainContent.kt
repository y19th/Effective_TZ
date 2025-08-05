package com.y19th.feature.home.main.ui

import androidx.compose.runtime.Composable
import com.y19th.core.ui.components.EffectiveColumn
import com.y19th.core.ui.components.EffectiveText
import com.y19th.dextension.compose.collectAsImmediateState
import com.y19th.dextension.compose.rememberHandleEvents

@Composable
internal fun MainContent(
    component: MainComponent
) { 
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()

    EffectiveColumn {
        EffectiveText(text = "MAIN HOME")
    }
}