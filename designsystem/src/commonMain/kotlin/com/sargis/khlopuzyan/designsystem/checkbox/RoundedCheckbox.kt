package com.sargis.khlopuzyan.designsystem.checkbox

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.designsystem.theme.AppTheme
import com.sargis.khlopuzyan.designsystem.theme.White

@Composable
fun RoundedCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    if (checked) {
        Box(
            modifier = modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(if (checked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface)
                .clickable { onCheckedChange(!checked) },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = Icons.Filled.Check,
                tint = White,
                contentDescription = "Checked"
            )
        }
    } else {
        Box(
            modifier = modifier
                .size(24.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = if (checked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                    shape = CircleShape
                )
                .background(if (checked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface)
                .clickable { onCheckedChange(!checked) },
            contentAlignment = Alignment.Center
        ) {}
    }
}

@Preview(name = "RoundedCheckbox - unchecked", showBackground = true)
@Composable
private fun RoundedCheckboxPreviewUnchecked() {
    AppTheme {
        RoundedCheckbox(
            checked = false,
            onCheckedChange = {}
        )
    }
}

@Preview(name = "RoundedCheckbox - checked", showBackground = true)
@Composable
private fun RoundedCheckboxPreviewChecked() {
    AppTheme {
        RoundedCheckbox(
            checked = true,
            onCheckedChange = {}
        )
    }
}

@Preview(name = "RoundedCheckbox - interactive", showBackground = true)
@Composable
private fun RoundedCheckboxPreviewInteractive() {
    var isChecked by remember { mutableStateOf(false) }

    AppTheme {
        RoundedCheckbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
    }
}
