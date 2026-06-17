package com.sargis.khlopuzyan.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
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
import com.sargis.khlopuzyan.designsystem.resources.SharedRes
import com.sargis.khlopuzyan.designsystem.resources.no_data_available
import com.sargis.khlopuzyan.designsystem.theme.AppTheme
import org.jetbrains.compose.resources.stringResource

@Composable
fun EmptyResultComponent(
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
    ) {
        image()
        content()
    }
}

@Preview(name = "EmptyResultComponent - Dark", showBackground = true)
@Composable
fun EmptyResultComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        EmptyResultComponent()
    }
}

@Preview(name = "EmptyResultComponent - Light", showBackground = true)
@Composable
fun EmptyResultComponentLightPreview() {
    AppTheme(darkTheme = false) {
        EmptyResultComponent()
    }
}

