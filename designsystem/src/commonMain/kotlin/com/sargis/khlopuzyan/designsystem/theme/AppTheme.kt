package com.sargis.khlopuzyan.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

private val LightColors = lightColorScheme(
    primary = PrimaryBlue,
    onPrimary = White,
    primaryContainer = White,
    onPrimaryContainer = Grey,
    secondary = SecondaryBlue,
    onSecondary = Black,
    background = White,
    onBackground = DarkGreyBackground,
    surface = White,
    onSurface = DarkAppBarBackground
)
private val DarkColors = darkColorScheme(
    primary = PrimaryBlue,
    onPrimary = White,
    primaryContainer = DarkGreyBackground,
    onPrimaryContainer = White,
    secondary = SecondaryBlueDark,
    onSecondary = White,
    background = DarkGreyBackground,
    onBackground = White,
    surface = DarkAppBarBackground,
    onSurface = White
)

val LocalDarkMode = staticCompositionLocalOf { false }

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors
    CompositionLocalProvider(LocalDarkMode provides darkTheme) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = getLotoTypography(),
            content = content
        )
    }
}