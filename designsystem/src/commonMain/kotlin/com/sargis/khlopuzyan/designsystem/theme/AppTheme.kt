package com.sargis.khlopuzyan.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import kotlinx.serialization.descriptors.PrimitiveKind

private val LightColors = lightColorScheme(
    primary = LightBlue,
    background = White,
    onBackground = DarkGrey
)
private val DarkColors = darkColorScheme(
    primary = LightBlue,
    background = DarkGrey,
    onBackground = White
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

