package com.y19th.feature.root.ui

import androidx.compose.runtime.Composable
import com.y19th.core.ui.theme.EffectiveTZTheme
import com.y19th.dextension.compose.DefaultChildren
import com.y19th.dextension.compose.ProvideContent

@Composable
internal fun RootContent(
    component: RootComponent
) {
    EffectiveTZTheme {
        DefaultChildren(
            stack = component.stack
        ) { instance ->
            ProvideContent(
                when (instance) {
                    is RootComponent.Child.Authenticate -> instance.screen
                    is RootComponent.Child.Home -> instance.screen
                }
            )
        }
    }
}