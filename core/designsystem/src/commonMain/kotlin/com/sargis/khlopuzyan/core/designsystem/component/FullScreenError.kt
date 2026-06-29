package com.sargis.khlopuzyan.core.designsystem.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.core.designsystem.preview.AppThemeDarkPreview
import com.sargis.khlopuzyan.core.designsystem.preview.AppThemeLightPreview
import com.sargis.khlopuzyan.core.designsystem.resources.SharedRes
import com.sargis.khlopuzyan.core.designsystem.resources.no_data_available
import org.jetbrains.compose.resources.stringResource

@Composable
fun FullScreenErrorComponent(
    text: String = stringResource(SharedRes.string.no_data_available),
    modifier: Modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
) {

    InfoComponent(
        modifier = modifier,
        image = {
            Icon(
                modifier = Modifier.size(120.dp),
                imageVector = Icons.Default.ErrorOutline,
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                contentDescription = null
            )
        },
        content = {
            Text(
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                text = text
            )
        }
    )
}

@Preview(name = "FullScreenErrorComponent - Dark", showBackground = true)
@Composable
fun FullScreenErrorComponentDarkPreview() {
    AppThemeDarkPreview {
        FullScreenErrorComponent()
    }
}

@Preview(name = "FullScreenErrorComponent - Light", showBackground = true)
@Composable
fun FullScreenErrorComponentLightPreview() {
    AppThemeLightPreview {
        FullScreenErrorComponent()
    }
}