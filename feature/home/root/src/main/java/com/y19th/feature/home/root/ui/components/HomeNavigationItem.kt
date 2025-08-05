package com.y19th.feature.home.root.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.y19th.core.ui.components.EffectiveText
import com.y19th.core.ui.theme.green
import com.y19th.core.ui.theme.scheme

@Composable
internal fun RowScope.HomeNavigationItem(
    selected: Boolean,
    labelText: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val state = rememberUpdatedState(selected)

    NavigationBarItem(
        modifier = modifier,
        selected = state.value,
        onClick = onClick,
        icon = {
            Icon(
                imageVector = icon,
                tint = if (state.value)
                    scheme.green else scheme.onSurface,
                contentDescription = null
            )
        },
        label = {
            EffectiveText(
                text = labelText,
                color = if (state.value)
                    scheme.green else scheme.onSurface,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp
            )
        },
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = Color(0xFF32333A)
        )
    )

}