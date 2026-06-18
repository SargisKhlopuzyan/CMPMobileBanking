package com.sargis.khlopuzyan.feature.menu.ui.map

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme

@Composable
fun MapScreen(
    viewModel: MapViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    MapComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun MapComponent(
    state: MapState,
    onAction: (MapAction) -> Unit,
) {

}

@Preview(name = "MapComponent - Dark", showBackground = true)
@Composable
private fun MapComponentLightPreview() {
    AppTheme(darkTheme = false) {
        MapComponent(
            state = MapState(),
            onAction = {}
        )
    }
}

@Preview(name = "MapComponent - Dark", showBackground = true)
@Composable
private fun MapComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        MapComponent(
            state = MapState(),
            onAction = {}
        )
    }
}