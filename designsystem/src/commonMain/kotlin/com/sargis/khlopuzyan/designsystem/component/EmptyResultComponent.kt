package com.sargis.khlopuzyan.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sargis.khlopuzyan.designsystem.resources.SharedRes
import com.sargis.khlopuzyan.designsystem.resources.ic_empty_search
import com.sargis.khlopuzyan.designsystem.resources.no_data_available
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun EmptyResultComponent(
    modifier: Modifier = Modifier.fillMaxSize(),
    image: @Composable () -> Unit? = {
        Icon(
            painter = painterResource(SharedRes.drawable.ic_empty_search),
            contentDescription = null
        )
    },
    content: @Composable () -> Unit? = {
        Text(
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

@Preview
@Composable
fun EmptyResultComponentPreview() {
    EmptyResultComponent()
}

