package com.sargis.khlopuzyan.feature.settings.ui.sorting

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.designsystem.theme.AppTheme

@Composable
fun SortingScreen(
    viewModel: SortingViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    SortingComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun SortingComponent(
    state: SortingState,
    onAction: (SortingAction) -> Unit,
) {

}

@Preview(name = "SortingComponent - Dark", showBackground = true)
@Composable
private fun SortingComponentLightPreview() {
    AppTheme(darkTheme = false) {
        SortingComponent(
            state = SortingState(),
            onAction = {}
        )
    }
}

@Preview(name = "SortingComponent - Dark", showBackground = true)
@Composable
private fun SortingComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        SortingComponent(
            state = SortingState(),
            onAction = {}
        )
    }
}