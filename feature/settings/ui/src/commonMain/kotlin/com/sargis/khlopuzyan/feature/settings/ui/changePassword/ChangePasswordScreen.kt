package com.sargis.khlopuzyan.feature.settings.ui.changePassword

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme

@Composable
fun ChangePasswordScreen(
    viewModel: ChangePasswordViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ChangePasswordComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun ChangePasswordComponent(
    state: ChangePasswordState,
    onAction: (ChangePasswordAction) -> Unit,
) {

}

@Preview(name = "ChangePasswordComponent - Dark", showBackground = true)
@Composable
private fun ChangePasswordComponentLightPreview() {
    AppTheme(darkTheme = false) {
        ChangePasswordComponent(
            state = ChangePasswordState(),
            onAction = {}
        )
    }
}

@Preview(name = "ChangePasswordComponent - Dark", showBackground = true)
@Composable
private fun ChangePasswordComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        ChangePasswordComponent(
            state = ChangePasswordState(),
            onAction = {}
        )
    }
}