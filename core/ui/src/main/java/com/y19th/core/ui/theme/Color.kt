package com.y19th.core.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

val scheme: ColorScheme @Composable get() = MaterialTheme.colorScheme

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Background = Color(0xFF151515)
val OnBackground = Color(0xFFF2F2F3)
val Surface = Color(0xFF32333A)
val OnSurface = Color(0xFFF2F2F3)

internal val DefaultGreen = Color(0xFF12B956)
internal val DefaultDarkGrey = Color(0xFF24252A)

private val greenColorState = mutableStateOf(DefaultGreen)
private val darkGreyColorState = mutableStateOf(DefaultDarkGrey)

val ColorScheme.green
    get() = greenColorState.value

val ColorScheme.darkGrey
    get() = darkGreyColorState.value