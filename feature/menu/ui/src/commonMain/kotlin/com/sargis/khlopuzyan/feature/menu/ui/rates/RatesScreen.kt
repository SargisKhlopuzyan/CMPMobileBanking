package com.sargis.khlopuzyan.feature.menu.ui.rates

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme

@Composable
fun RatesScreen(
    viewModel: RatesViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    RatesComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun RatesComponent(
    state: RatesState,
    onAction: (RatesAction) -> Unit,
) {

}

@Preview(name = "RatesComponent - Dark", showBackground = true)
@Composable
private fun RatesComponentLightPreview() {
    AppTheme(darkTheme = false) {
        RatesComponent(
            state = RatesState(),
            onAction = {}
        )
    }
}

@Preview(name = "RatesComponent - Dark", showBackground = true)
@Composable
private fun RatesComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        RatesComponent(
            state = RatesState(),
            onAction = {}
        )
    }
}