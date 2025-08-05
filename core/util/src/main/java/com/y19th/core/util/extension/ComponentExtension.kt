package com.y19th.core.util.extension

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.coroutines.withLifecycle
import com.y19th.dextension.core.BaseComponent
import com.y19th.dextension.koin.KoinScreen
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class EmptyScreen(
    override val componentContext: ComponentContext
) : KoinScreen {

    @Composable
    override fun Content() {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = Color.Black
            )
        }
    }
}

fun <T> Flow<T>.launchLifecycle(component: BaseComponent) = component.scope.launch {
    this@launchLifecycle.withLifecycle(component.lifecycle).stateIn(this)
}
