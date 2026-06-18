package com.sargis.khlopuzyan.core.designsystem.button

import androidx.compose.foundation.BorderStroke
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
import com.sargis.khlopuzyan.core.designsystem.resources.SharedRes
import com.sargis.khlopuzyan.core.designsystem.resources.compose_multiplatform
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme
import com.sargis.khlopuzyan.core.designsystem.theme.PrimaryBlue
import com.sargis.khlopuzyan.core.designsystem.theme.Transparent
import org.jetbrains.compose.resources.painterResource

@Composable
fun SecondaryButton(
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
            containerColor = Transparent,
            contentColor = PrimaryBlue
        ),
        border = BorderStroke(
            width = 1.dp,
            color = PrimaryBlue
        ),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier.wrapContentWidth().height(48.dp)
    ) {
        Row(
            modifier = Modifier.wrapContentWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon != null) {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = PrimaryBlue
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                text = text,
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center,
                color = PrimaryBlue
            )
        }
    }
}

// ─── Previews ────────────────────────────────────────────────────────────────

@Preview(showBackground = true)
@Composable
private fun SecondaryButtonPreview() {
    AppTheme(darkTheme = false) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SecondaryButton(
                text = "Secondary Button",
                icon = painterResource(SharedRes.drawable.compose_multiplatform),
                onClick = {}
            )
            SecondaryButton(
                text = "Secondary Button",
                onClick = {}
            )
            SecondaryButton(
                text = "Secondary Button",
                icon = painterResource(SharedRes.drawable.compose_multiplatform),
                enabled = false,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SecondaryButtonDarkThemePreview() {
    AppTheme(darkTheme = true) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SecondaryButton(
                text = "Secondary Button",
                icon = painterResource(SharedRes.drawable.compose_multiplatform),
                onClick = {}
            )
            SecondaryButton(
                text = "Secondary Button",
                onClick = {}
            )
            SecondaryButton(
                text = "Secondary Button",
                icon = painterResource(SharedRes.drawable.compose_multiplatform),
                enabled = false,
                onClick = {}
            )
        }
    }
}
