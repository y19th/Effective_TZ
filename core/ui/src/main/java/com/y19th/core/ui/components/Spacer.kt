package com.y19th.core.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
@NonRestartableComposable
@Stable
fun VerticalSpacer(
    height: Dp = 4.dp,
    modifier: Modifier = Modifier
) {
    Spacer(
        modifier = Modifier
            .height(height)
            .then(modifier)
    )
}

@Stable
@NonRestartableComposable
@Composable
fun HorizontalSpacer(
    width: Dp = 4.dp,
    modifier: Modifier = Modifier
) {
    Spacer(
        modifier = Modifier
            .width(width)
            .then(modifier)
    )
}