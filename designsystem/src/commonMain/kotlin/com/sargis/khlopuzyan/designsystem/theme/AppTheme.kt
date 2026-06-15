package com.sargis.khlopuzyan.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = LightBlue,
    primaryContainer = White,
    background = White,
    onBackground = DarkGreyBackground,
    surface = White,
    onSurface = DarkAppBarBackground
)
private val DarkColors = darkColorScheme(
    primary = LightBlue,
    primaryContainer = DarkGreyBackground,
    background = DarkGreyBackground,
    onBackground = White,
    surface = DarkAppBarBackground,
    onSurface = White
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors
    MaterialTheme(
        colorScheme = colorScheme,
        typography = getLotoTypography(),
        content = content
    )
}