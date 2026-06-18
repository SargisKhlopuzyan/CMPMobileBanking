package com.sargis.khlopuzyan.feature.menu.ui.vehicles

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.designsystem.theme.AppTheme

@Composable
fun VehiclesScreen(
    viewModel: VehiclesViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    VehiclesComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun VehiclesComponent(
    state: VehiclesState,
    onAction: (VehiclesAction) -> Unit,
) {

}

@Preview(name = "VehiclesComponent - Dark", showBackground = true)
@Composable
private fun VehiclesComponentLightPreview() {
    AppTheme(darkTheme = false) {
        VehiclesComponent(
            state = VehiclesState(),
            onAction = {}
        )
    }
}

@Preview(name = "VehiclesComponent - Dark", showBackground = true)
@Composable
private fun VehiclesComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        VehiclesComponent(
            state = VehiclesState(),
            onAction = {}
        )
    }
}