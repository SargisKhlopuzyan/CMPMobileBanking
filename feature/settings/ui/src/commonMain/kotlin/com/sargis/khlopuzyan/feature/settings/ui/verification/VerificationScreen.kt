package com.sargis.khlopuzyan.feature.settings.ui.verification

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.designsystem.theme.AppTheme

@Composable
fun VerificationScreen(
    viewModel: VerificationViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    VerificationComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun VerificationComponent(
    state: VerificationState,
    onAction: (VerificationAction) -> Unit,
) {

}

@Preview(name = "VerificationComponent - Dark", showBackground = true)
@Composable
private fun VerificationComponentLightPreview() {
    AppTheme(darkTheme = false) {
        VerificationComponent(
            state = VerificationState(),
            onAction = {}
        )
    }
}

@Preview(name = "VerificationComponent - Dark", showBackground = true)
@Composable
private fun VerificationComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        VerificationComponent(
            state = VerificationState(),
            onAction = {}
        )
    }
}