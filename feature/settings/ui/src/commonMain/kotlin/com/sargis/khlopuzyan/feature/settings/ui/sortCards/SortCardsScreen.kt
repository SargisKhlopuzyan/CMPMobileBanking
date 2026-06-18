package com.sargis.khlopuzyan.feature.settings.ui.sortCards

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme

@Composable
fun SortCardsScreen(
    viewModel: SortCardsViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    SortCardsComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun SortCardsComponent(
    state: SortCardsState,
    onAction: (SortCardsAction) -> Unit,
) {

}

@Preview(name = "SortCardsComponent - Dark", showBackground = true)
@Composable
private fun SortCardsComponentLightPreview() {
    AppTheme(darkTheme = false) {
        SortCardsComponent(
            state = SortCardsState(),
            onAction = {}
        )
    }
}

@Preview(name = "SortCardsComponent - Dark", showBackground = true)
@Composable
private fun SortCardsComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        SortCardsComponent(
            state = SortCardsState(),
            onAction = {}
        )
    }
}