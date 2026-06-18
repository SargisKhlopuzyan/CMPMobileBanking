package com.sargis.khlopuzyan.feature.settings.ui.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.designsystem.theme.AppTheme

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    SettingsComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun SettingsComponent(
    state: SettingsState,
    onAction: (SettingsAction) -> Unit,
) {

}

@Preview(name = "SettingsComponent - Dark", showBackground = true)
@Composable
private fun SettingsComponentLightPreview() {
    AppTheme(darkTheme = false) {
        SettingsComponent(
            state = SettingsState(),
            onAction = {}
        )
    }
}

@Preview(name = "SettingsComponent - Dark", showBackground = true)
@Composable
private fun SettingsComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        SettingsComponent(
            state = SettingsState(),
            onAction = {}
        )
    }
}