package com.y19th.feature.home.ui

import androidx.compose.runtime.Composable
import com.y19th.dextension.compose.collectAsImmediateState
import com.y19th.dextension.compose.rememberHandleEvents

@Composable
internal fun HomeContent(
    component: HomeComponent
) { 
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()                
}