package com.sargis.khlopuzyan.feature.menu.ui.moneyInjunctions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.designsystem.theme.AppTheme

@Composable
fun MoneyInjunctionsScreen(
    viewModel: MoneyInjunctionsViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    MoneyInjunctionsComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun MoneyInjunctionsComponent(
    state: MoneyInjunctionsState,
    onAction: (MoneyInjunctionsAction) -> Unit,
) {

}

@Preview(name = "MoneyInjunctionsComponent - Dark", showBackground = true)
@Composable
private fun MoneyInjunctionsComponentLightPreview() {
    AppTheme(darkTheme = false) {
        MoneyInjunctionsComponent(
            state = MoneyInjunctionsState(),
            onAction = {}
        )
    }
}

@Preview(name = "MoneyInjunctionsComponent - Dark", showBackground = true)
@Composable
private fun MoneyInjunctionsComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        MoneyInjunctionsComponent(
            state = MoneyInjunctionsState(),
            onAction = {}
        )
    }
}