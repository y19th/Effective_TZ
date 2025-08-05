package com.y19th.core.ui.components.fields

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.y19th.core.ui.components.EffectiveText
import com.y19th.core.ui.theme.scheme


@Composable
internal fun decoratedSupportingText(text: String): (@Composable () -> Unit)? =
    if (text.isNotEmpty())
        @Composable {
            {
                EffectiveText(
                    text = text,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                )
            }
        } else null

@Composable
internal fun decoratedLeadingIcon(icon: ImageVector?): (@Composable () -> Unit)? =
    if (icon != null)
        @Composable {
            {
                Icon(
                    imageVector = icon,
                    tint = scheme.onSurface,
                    contentDescription = "leading_labelled"
                )
            }
        } else null

@Composable
internal fun decoratedPlaceholderText(text: String): (@Composable () -> Unit)? =
    if (text.isNotEmpty())
        @Composable {
            {
                EffectiveText(
                    text = text,
                    color = if (isSystemInDarkTheme())
                        scheme.onSurface else scheme.outline,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    lineHeight = 20.sp
                )
            }
        } else null



