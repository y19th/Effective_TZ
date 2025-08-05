package com.y19th.feature.home.account.ui

import androidx.compose.runtime.Composable
import com.y19th.dextension.compose.collectAsImmediateState
import com.y19th.dextension.compose.rememberHandleEvents

@Composable
internal fun AccountContent(
    component: AccountComponent
) { 
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()                
}