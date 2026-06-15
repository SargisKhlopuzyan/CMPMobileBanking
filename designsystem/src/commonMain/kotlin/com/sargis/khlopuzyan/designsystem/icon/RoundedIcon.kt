package com.sargis.khlopuzyan.designsystem.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.designsystem.resources.SharedRes
import com.sargis.khlopuzyan.designsystem.resources.compose_multiplatform
import com.sargis.khlopuzyan.designsystem.theme.AppTheme
import com.sargis.khlopuzyan.designsystem.theme.Grey
import com.sargis.khlopuzyan.designsystem.theme.LightBlue
import org.jetbrains.compose.resources.painterResource

/**
 * A composable that displays an image icon centered inside a
 * rounded-corner box. The areas outside the rounded shape (the corners)
 * use the current Material theme background color, giving the
 * "rounded background with black corners" effect.
 *
 * @param painter      The [Painter] to draw as the icon.
 * @param contentDescription Accessibility description for the image.
 * @param size         Overall size of the rounded box.
 * @param cornerRadius Radius of the rounded corners.
 * @param borderWidth Thickness of the border drawn around the shape. Use [Dp.Unspecified] or 0.dp to hide it.
 * @param borderColor Color of the border (default black).
 * @param modifier     Additional modifiers for the outer container.
 */
@Composable
fun RoundedIcon(
    painter: Painter,
    isDarkTheme: Boolean,
    contentDescription: String? = null,
    size: Dp = 42.dp,
    cornerRadius: Dp = 8.dp,
    borderWidth: Dp = 0.5.dp,
    borderColor: Color = Grey,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(cornerRadius)
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(size)
            .border(width = borderWidth, color = borderColor, shape = shape)
            .clip(shape)
            .background(if (isDarkTheme) MaterialTheme.colorScheme.background else Color.White)
    ) {
        Image(
            painter = painter,
            colorFilter = ColorFilter.tint(if (isDarkTheme) LightBlue else Color.Black),
            contentDescription = contentDescription,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(size * 0.5f)   // icon takes 50 % of the box
        )
    }
}

// ─── Previews ────────────────────────────────────────────────────────────────

@Preview(name = "RoundedIcon – default (black border, 56 dp)")
@Composable
private fun RoundedIconPreviewDefault() {
    AppTheme {
        RoundedIcon(
            painter = painterResource(SharedRes.drawable.compose_multiplatform),
            isDarkTheme = false,
            contentDescription = "Compose Multiplatform"
        )
    }
}

@Preview(name = "RoundedIcon – no border")
@Composable
private fun RoundedIconPreviewNoBorder() {
    AppTheme {
        RoundedIcon(
            painter = painterResource(SharedRes.drawable.compose_multiplatform),
            isDarkTheme = false,
            contentDescription = "No border",
            borderWidth = 0.dp
        )
    }
}

@Preview(name = "RoundedIcon – multiple sizes")
@Composable
private fun RoundedIconPreviewSizes() {
    AppTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
        ) {
            listOf(40.dp, 56.dp, 72.dp, 88.dp).forEach { iconSize ->
                RoundedIcon(
                    painter = painterResource(SharedRes.drawable.compose_multiplatform),
                    isDarkTheme = false,
                    contentDescription = null,
                    size = iconSize
                )
            }
        }
    }
}

@Preview(name = "RoundedIcon – default dark")
@Composable
private fun RoundedIconPreviewDefaultDark() {
    AppTheme(darkTheme = true) {
        RoundedIcon(
            painter = painterResource(SharedRes.drawable.compose_multiplatform),
            isDarkTheme = true,
            contentDescription = "Compose Multiplatform"
        )
    }
}

@Preview(name = "RoundedIcon – no border dark")
@Composable
private fun RoundedIconPreviewNoBorderDark() {
    AppTheme(darkTheme = true) {
        RoundedIcon(
            painter = painterResource(SharedRes.drawable.compose_multiplatform),
            isDarkTheme = true,
            contentDescription = "No border",
            borderWidth = 0.dp
        )
    }
}

@Preview(name = "RoundedIcon – multiple sizes dark")
@Composable
private fun RoundedIconPreviewSizesDark() {
    AppTheme(darkTheme = true) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color.Black)
                .padding(16.dp)
        ) {
            listOf(40.dp, 56.dp, 72.dp, 88.dp).forEach { iconSize ->
                RoundedIcon(
                    painter = painterResource(SharedRes.drawable.compose_multiplatform),
                    isDarkTheme = true,
                    contentDescription = null,
                    size = iconSize
                )
            }
        }
    }
}