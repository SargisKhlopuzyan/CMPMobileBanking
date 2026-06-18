package com.sargis.khlopuzyan.feature.settings.ui.settingsForReceivingArcaPayTransfers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.designsystem.theme.AppTheme

@Composable
fun SettingsForReceivingArcaPayTransfersScreen(
    viewModel: SettingsForReceivingArcaPayTransfersViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    SettingsForReceivingArcaPayTransfersComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun SettingsForReceivingArcaPayTransfersComponent(
    state: SettingsForReceivingArcaPayTransfersState,
    onAction: (SettingsForReceivingArcaPayTransfersAction) -> Unit,
) {

}

@Preview(name = "SettingsForReceivingArcaPayTransfersComponent - Dark", showBackground = true)
@Composable
private fun SettingsForReceivingArcaPayTransfersComponentLightPreview() {
    AppTheme(darkTheme = false) {
        SettingsForReceivingArcaPayTransfersComponent(
            state = SettingsForReceivingArcaPayTransfersState(),
            onAction = {}
        )
    }
}

@Preview(name = "SettingsForReceivingArcaPayTransfersComponent - Dark", showBackground = true)
@Composable
private fun SettingsForReceivingArcaPayTransfersComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        SettingsForReceivingArcaPayTransfersComponent(
            state = SettingsForReceivingArcaPayTransfersState(),
            onAction = {}
        )
    }
}