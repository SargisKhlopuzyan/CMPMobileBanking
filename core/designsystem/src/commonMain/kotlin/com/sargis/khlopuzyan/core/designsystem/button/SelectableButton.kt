package com.sargis.khlopuzyan.core.designsystem.button

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.core.designsystem.resources.SharedRes
import com.sargis.khlopuzyan.core.designsystem.resources.compose_multiplatform
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme
import com.sargis.khlopuzyan.core.designsystem.theme.DarkGreyBackground
import com.sargis.khlopuzyan.core.designsystem.theme.Grey
import com.sargis.khlopuzyan.core.designsystem.theme.LocalDarkMode
import com.sargis.khlopuzyan.core.designsystem.theme.PrimaryBlue
import org.jetbrains.compose.resources.painterResource

@Composable
fun SelectableButton(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier.wrapContentWidth().height(40.dp),
    leadingIcon: Painter? = null,
    trailingIcon: Painter? = null,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    val isDarkMode = LocalDarkMode.current

    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = when {
                selected -> MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
                else -> MaterialTheme.colorScheme.background
            },
            contentColor = MaterialTheme.colorScheme.onSecondary
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = 0.5.dp,
            color = when {
                selected -> MaterialTheme.colorScheme.primary
                isDarkMode -> Grey
                else -> DarkGreyBackground
            }
        ),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier.wrapContentWidth().height(32.dp)
    ) {
        Row(
            modifier = Modifier.wrapContentWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (leadingIcon != null) {
                Icon(
                    painter = leadingIcon,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = PrimaryBlue
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground
            )
            if (trailingIcon != null) {
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = trailingIcon,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = PrimaryBlue
                )
            }
        }
    }
}

@Composable
private fun getSelectableButtonBorderColor(
    selected: Boolean,
): androidx.compose.ui.graphics.Color {
    return when {
        selected -> MaterialTheme.colorScheme.primary
        else -> PrimaryBlue
    }
}

// ─── Previews ────────────────────────────────────────────────────────────────

@Preview(showBackground = true)
@Composable
private fun SelectableButtonPreview() {
    AppTheme(darkTheme = false) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SelectableButton(
                text = "Button",
                selected = true,
                leadingIcon = rememberVectorPainter(Icons.Default.Check),
                trailingIcon = rememberVectorPainter(Icons.Default.Close),
                onClick = {}
            )
            SelectableButton(
                text = "Button",
                selected = true,
                onClick = {}
            )
            SelectableButton(
                text = "Button",
                selected = false,
                leadingIcon = painterResource(SharedRes.drawable.compose_multiplatform),
                trailingIcon = painterResource(SharedRes.drawable.compose_multiplatform),
                onClick = {}
            )
            SelectableButton(
                text = "Button",
                selected = false,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SelectableButtonDarkThemePreview() {
    AppTheme(darkTheme = true) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SelectableButton(
                text = "Button",
                selected = true,
                leadingIcon = rememberVectorPainter(Icons.Default.Check),
                trailingIcon = rememberVectorPainter(Icons.Default.Close),
                onClick = {}
            )
            SelectableButton(
                text = "Button",
                selected = true,
                onClick = {}
            )
            SelectableButton(
                text = "Button",
                selected = false,
                leadingIcon = painterResource(SharedRes.drawable.compose_multiplatform),
                trailingIcon = painterResource(SharedRes.drawable.compose_multiplatform),
                onClick = {}
            )
            SelectableButton(
                text = "Button",
                selected = false,
                onClick = {}
            )
        }
    }
}