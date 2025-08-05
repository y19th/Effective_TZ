package com.y19th.feature.authenticate.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.composeunstyled.Button
import com.y19th.core.ui.components.HorizontalSpacer
import com.y19th.feature.authenticate.R
import com.y19th.feature.authenticate.logic.AuthenticateEvents

@Composable
internal fun SocialContent(
    modifier: Modifier = Modifier,
    onEvent: (AuthenticateEvents) -> Unit
) {
    val okBrush = Brush.linearGradient(
        colors = listOf(Color(0xFFF98509), Color(0xFFF95D00))
    )

    Row(
        modifier = modifier
    ) {
        Button(
            modifier = Modifier
                .weight(0.5f),
            backgroundColor = Color(0xFF2683ED),
            shape = RoundedCornerShape(30.dp),
            onClick = { onEvent(AuthenticateEvents.OnVkClicked) }
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.icon_vk),
                tint = Color.White,
                contentDescription = null
            )
        }

        HorizontalSpacer(16.dp)

        Button(
            modifier = Modifier
                .weight(0.5f)
                .drawBehind {
                    drawRoundRect(
                        brush = okBrush,
                        cornerRadius = CornerRadius(30.dp.toPx())
                    )
                },
            backgroundColor = Color.Transparent,
            shape = RoundedCornerShape(30.dp),
            onClick = { onEvent(AuthenticateEvents.OnOkClicked) }
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.icon_ok),
                tint = Color.White,
                contentDescription = null
            )
        }
    }
}