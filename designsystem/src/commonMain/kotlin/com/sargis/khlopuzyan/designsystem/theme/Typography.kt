package com.sargis.khlopuzyan.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun getLotoTypography(): Typography {
    val Lato = getLotoFontFamily()

    return Typography(
        titleSmall = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
        ),
        titleMedium = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
        ),
        titleLarge = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
        ),
        bodySmall = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
        ),
        bodyMedium = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
        ),
        bodyLarge = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
        ),
        labelSmall = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
        ),
        labelMedium = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
        ),
        labelLarge = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
        )
    )
}