package com.sargis.khlopuzyan.feature.settings.ui.devices

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme

@Composable
fun DevicesScreen(
    viewModel: DevicesViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    DevicesComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun DevicesComponent(
    state: DevicesState,
    onAction: (DevicesAction) -> Unit,
) {

}

@Preview(name = "DevicesComponent - Dark", showBackground = true)
@Composable
private fun DevicesComponentLightPreview() {
    AppTheme(darkTheme = false) {
        DevicesComponent(
            state = DevicesState(),
            onAction = {}
        )
    }
}

@Preview(name = "DevicesComponent - Dark", showBackground = true)
@Composable
private fun DevicesComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        DevicesComponent(
            state = DevicesState(),
            onAction = {}
        )
    }
}