package com.sargis.khlopuzyan.feature.menu.ui.calculator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme

@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    CalculatorComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun CalculatorComponent(
    state: CalculatorState,
    onAction: (CalculatorAction) -> Unit,
) {

}

@Preview(name = "CalculatorComponent - Dark", showBackground = true)
@Composable
private fun CalculatorComponentLightPreview() {
    AppTheme(darkTheme = false) {
        CalculatorComponent(
            state = CalculatorState(),
            onAction = {}
        )
    }
}

@Preview(name = "CalculatorComponent - Dark", showBackground = true)
@Composable
private fun CalculatorComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        CalculatorComponent(
            state = CalculatorState(),
            onAction = {}
        )
    }
}