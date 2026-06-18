package com.sargis.khlopuzyan.feature.settings.ui.security

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.designsystem.theme.AppTheme

@Composable
fun SecurityScreen(
    viewModel: SecurityViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    SecurityComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun SecurityComponent(
    state: SecurityState,
    onAction: (SecurityAction) -> Unit,
) {

}

@Preview(name = "SecurityComponent - Dark", showBackground = true)
@Composable
private fun SecurityComponentLightPreview() {
    AppTheme(darkTheme = false) {
        SecurityComponent(
            state = SecurityState(),
            onAction = {}
        )
    }
}

@Preview(name = "SecurityComponent - Dark", showBackground = true)
@Composable
private fun SecurityComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        SecurityComponent(
            state = SecurityState(),
            onAction = {}
        )
    }
}