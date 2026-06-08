package com.sargis.khlopuzyan.designsystem.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.border
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cmpmobilebanking.designsystem.generated.resources.Res
import cmpmobilebanking.designsystem.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource

/**
 * A composable that displays an image icon centered inside a
 * rounded-corner box. The areas outside the rounded shape (the corners)
 * appear in [backgroundColor] (default: black), giving the
 * "rounded background with black corners" effect.
 *
 * @param painter      The [Painter] to draw as the icon.
 * @param contentDescription Accessibility description for the image.
 * @param size         Overall size of the rounded box.
 * @param cornerRadius Radius of the rounded corners.
 * @param backgroundColor Color shown in the corner areas (default black).
 * @param borderWidth Thickness of the border drawn around the shape. Use [Dp.Unspecified] or 0.dp to hide it.
 * @param borderColor Color of the border (default black).
 * @param modifier     Additional modifiers for the outer container.
 */
@Composable
fun RoundedIcon(
    painter: Painter,
    contentDescription: String? = null,
    size: Dp = 56.dp,
    cornerRadius: Dp = 12.dp,
    backgroundColor: Color = Color.White,
    borderWidth: Dp = 2.dp,
    borderColor: Color = Color.Black,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(cornerRadius)
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(size)
            .border(width = borderWidth, color = borderColor, shape = shape)
            .clip(shape)
            .background(backgroundColor)
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(size * 0.6f)   // icon takes 60 % of the box
        )
    }
}

// ─── Previews ────────────────────────────────────────────────────────────────

@Preview(name = "RoundedIcon – default (black border, 56 dp)")
@Composable
private fun RoundedIconPreviewDefault() {
    MaterialTheme {
        RoundedIcon(
            painter = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = "Compose Multiplatform"
        )
    }
}

@Preview(name = "RoundedIcon – no border")
@Composable
private fun RoundedIconPreviewNoBorder() {
    MaterialTheme {
        RoundedIcon(
            painter = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = "No border",
            borderWidth = 0.dp
        )
    }
}

@Preview(name = "RoundedIcon – multiple sizes")
@Composable
private fun RoundedIconPreviewSizes() {
    MaterialTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
        ) {
            listOf(40.dp, 56.dp, 72.dp, 88.dp).forEach { iconSize ->
                RoundedIcon(
                    painter = painterResource(Res.drawable.compose_multiplatform),
                    contentDescription = null,
                    size = iconSize
                )
            }
        }
    }
}

