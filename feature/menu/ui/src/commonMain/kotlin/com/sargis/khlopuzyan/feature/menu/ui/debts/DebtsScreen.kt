package com.sargis.khlopuzyan.feature.menu.ui.debts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme

@Composable
fun DebtsScreen(
    viewModel: DebtsViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    DebtsComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun DebtsComponent(
    state: DebtsState,
    onAction: (DebtsAction) -> Unit,
) {

}

@Preview(name = "DebtsComponent - Dark", showBackground = true)
@Composable
private fun DebtsComponentLightPreview() {
    AppTheme(darkTheme = false) {
        DebtsComponent(
            state = DebtsState(),
            onAction = {}
        )
    }
}

@Preview(name = "DebtsComponent - Dark", showBackground = true)
@Composable
private fun DebtsComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        DebtsComponent(
            state = DebtsState(),
            onAction = {}
        )
    }
}