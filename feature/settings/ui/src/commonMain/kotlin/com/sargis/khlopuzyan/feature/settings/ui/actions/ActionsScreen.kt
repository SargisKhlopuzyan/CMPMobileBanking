package com.sargis.khlopuzyan.feature.settings.ui.actions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme

@Composable
fun ActionsScreen(
    viewModel: ActionsViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ActionsComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun ActionsComponent(
    state: ActionsState,
    onAction: (ActionsAction) -> Unit,
) {

}

@Preview(name = "ActionsComponent - Dark", showBackground = true)
@Composable
private fun ActionsComponentLightPreview() {
    AppTheme(darkTheme = false) {
        ActionsComponent(
            state = ActionsState(),
            onAction = {}
        )
    }
}

@Preview(name = "ActionsComponent - Dark", showBackground = true)
@Composable
private fun ActionsComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        ActionsComponent(
            state = ActionsState(),
            onAction = {}
        )
    }
}