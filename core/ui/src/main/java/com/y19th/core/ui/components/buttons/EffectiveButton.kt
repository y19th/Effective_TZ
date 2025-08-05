package com.y19th.core.ui.components.buttons

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composeunstyled.Button
import com.y19th.core.ui.components.EffectiveText
import com.y19th.core.ui.theme.scheme

@Composable
fun EffectiveButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: RoundedCornerShape = CircleShape,
    contentPadding: PaddingValues = PaddingValues(vertical = 10.dp, horizontal = 12.dp),
    contentColor: Color = scheme.onSurface,
    backgroundColor: Color = scheme.surface,
    onClick: () -> Unit
) {
    val backgroundColor = animateColorAsState(
        targetValue = if (enabled) backgroundColor else Color.Gray
    )

    Button(
        modifier = modifier,
        shape = shape,
        enabled = enabled,
        contentPadding = contentPadding,
        contentColor = contentColor,
        backgroundColor = backgroundColor.value,
        onClick = onClick
    ) {
        EffectiveText(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = contentColor
        )
    }

}