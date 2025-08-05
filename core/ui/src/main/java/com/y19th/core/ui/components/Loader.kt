package com.y19th.core.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.y19th.core.ui.theme.scheme

@Composable
fun Loader(
    modifier: Modifier = Modifier,
    color: Color = scheme.onSurface
) {
    CenteredBox (
        modifier = modifier
            .fillMaxSize()
    ) {
        CircularProgressIndicator(
            color = color
        )
    }
}