package com.sargis.khlopuzyan.feature.menu.ui.bonds

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme

@Composable
fun BondsScreen(
    viewModel: BondsViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    BondsComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun BondsComponent(
    state: BondsState,
    onAction: (BondsAction) -> Unit,
) {

}

@Preview(name = "BondsComponent - Dark", showBackground = true)
@Composable
private fun BondsComponentLightPreview() {
    AppTheme(darkTheme = false) {
        BondsComponent(
            state = BondsState(),
            onAction = {}
        )
    }
}

@Preview(name = "BondsComponent - Dark", showBackground = true)
@Composable
private fun BondsComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        BondsComponent(
            state = BondsState(),
            onAction = {}
        )
    }
}