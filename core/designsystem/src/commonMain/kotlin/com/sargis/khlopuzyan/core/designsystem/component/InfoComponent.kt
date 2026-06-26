package com.sargis.khlopuzyan.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.core.designsystem.resources.SharedRes
import com.sargis.khlopuzyan.core.designsystem.resources.no_data_available
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme
import org.jetbrains.compose.resources.stringResource

@Composable
fun InfoComponent(
    modifier: Modifier = Modifier.fillMaxSize(),
    image: @Composable () -> Unit? = {
        Icon(
            modifier = Modifier.size(120.dp),
            imageVector = Icons.Default.SearchOff,
            tint = MaterialTheme.colorScheme.onPrimaryContainer,
            contentDescription = null
        )
    },
    content: @Composable () -> Unit? = {
        Text(
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            text = stringResource(SharedRes.string.no_data_available)
        )
    }
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        image()
        content()
    }
}

@Preview(name = "InfoComponent - Dark", showBackground = true)
@Composable
fun InfoComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        InfoComponent()
    }
}

@Preview(name = "InfoComponent - Light", showBackground = true)
@Composable
fun InfoComponentLightPreview() {
    AppTheme(darkTheme = false) {
        InfoComponent()
    }
}

