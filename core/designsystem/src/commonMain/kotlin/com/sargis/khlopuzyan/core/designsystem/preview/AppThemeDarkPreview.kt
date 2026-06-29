package com.sargis.khlopuzyan.core.designsystem.preview

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme

@Composable
fun AppThemeDarkPreview(
    content: @Composable () -> Unit
) {
    AppTheme(darkTheme = true) {
        Surface {
            content()
        }
    }
}