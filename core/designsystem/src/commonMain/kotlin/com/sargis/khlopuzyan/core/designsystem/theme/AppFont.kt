package com.sargis.khlopuzyan.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.sargis.khlopuzyan.core.designsystem.resources.SharedRes
import com.sargis.khlopuzyan.core.designsystem.resources.lato_black
import com.sargis.khlopuzyan.core.designsystem.resources.lato_bold
import com.sargis.khlopuzyan.core.designsystem.resources.lato_light
import com.sargis.khlopuzyan.core.designsystem.resources.lato_medium
import com.sargis.khlopuzyan.core.designsystem.resources.lato_regular
import com.sargis.khlopuzyan.core.designsystem.resources.lato_semi_bold
import com.sargis.khlopuzyan.core.designsystem.resources.lato_thin
import org.jetbrains.compose.resources.Font

@Composable
fun getLotoFontFamily(): FontFamily = FontFamily(
    Font(SharedRes.font.lato_black, FontWeight.Black),
    Font(SharedRes.font.lato_bold, FontWeight.Bold),
    Font(SharedRes.font.lato_light, FontWeight.Light),
    Font(SharedRes.font.lato_medium, FontWeight.Medium),
    Font(SharedRes.font.lato_regular, FontWeight.Normal),
    Font(SharedRes.font.lato_semi_bold, FontWeight.SemiBold),
    Font(SharedRes.font.lato_thin, FontWeight.Thin),
)