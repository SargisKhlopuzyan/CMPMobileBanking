package com.sargis.khlopuzyan.feature.settings.ui.settingsForReceivingTransferViaPhoneNumber

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.designsystem.theme.AppTheme

@Composable
fun SettingsForReceivingTransferViaPhoneNumberScreen(
    viewModel: SettingsForReceivingTransferViaPhoneNumberViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    SettingsForReceivingTransferViaPhoneNumberComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun SettingsForReceivingTransferViaPhoneNumberComponent(
    state: SettingsForReceivingTransferViaPhoneNumberState,
    onAction: (SettingsForReceivingTransferViaPhoneNumberAction) -> Unit,
) {

}

@Preview(name = "SettingsForReceivingTransferViaPhoneNumberComponent - Dark", showBackground = true)
@Composable
private fun SettingsForReceivingTransferViaPhoneNumberComponentLightPreview() {
    AppTheme(darkTheme = false) {
        SettingsForReceivingTransferViaPhoneNumberComponent(
            state = SettingsForReceivingTransferViaPhoneNumberState(),
            onAction = {}
        )
    }
}

@Preview(name = "SettingsForReceivingTransferViaPhoneNumberComponent - Dark", showBackground = true)
@Composable
private fun SettingsForReceivingTransferViaPhoneNumberComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        SettingsForReceivingTransferViaPhoneNumberComponent(
            state = SettingsForReceivingTransferViaPhoneNumberState(),
            onAction = {}
        )
    }
}