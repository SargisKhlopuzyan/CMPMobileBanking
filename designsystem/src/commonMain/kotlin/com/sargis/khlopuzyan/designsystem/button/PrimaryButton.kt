package com.sargis.khlopuzyan.designsystem.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.designsystem.resources.SharedRes
import com.sargis.khlopuzyan.designsystem.resources.compose_multiplatform
import com.sargis.khlopuzyan.designsystem.theme.AppTheme
import com.sargis.khlopuzyan.designsystem.theme.White
import org.jetbrains.compose.resources.painterResource

/**
 * A full-width button with a leading [icon], centered [text] label,
 * and a filled primary background color.
 */
@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier.wrapContentWidth().height(48.dp),
    icon: Painter? = null,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier.wrapContentWidth().height(48.dp)
    ) {
        // Overlay: icon pinned to the left, text truly centred in the full width
        Row(
            modifier = Modifier.wrapContentWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Leading icon aligned to the start
            if (icon != null) {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = White
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                text = text,
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center,
                color = White
            )
        }
    }
}

// ─── Previews ────────────────────────────────────────────────────────────────

@Preview(showBackground = true)
@Composable
private fun PrimaryButtonPreview() {
    AppTheme(darkTheme = false) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PrimaryButton(
                text = "Confirm Payment",
                icon = painterResource(SharedRes.drawable.compose_multiplatform),
                onClick = {}
            )
            PrimaryButton(
                text = "Confirm Payment",
                onClick = {}
            )
            PrimaryButton(
                text = "Confirm Payment",
                icon = painterResource(SharedRes.drawable.compose_multiplatform),
                enabled = false,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PrimaryButtonDarkThemePreview() {
    AppTheme(darkTheme = true) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PrimaryButton(
                text = "Confirm Payment",
                icon = painterResource(SharedRes.drawable.compose_multiplatform),
                onClick = {}
            )
            PrimaryButton(
                text = "Confirm Payment",
                onClick = {}
            )
            PrimaryButton(
                text = "Confirm Payment",
                icon = painterResource(SharedRes.drawable.compose_multiplatform),
                enabled = false,
                onClick = {}
            )
        }
    }
}