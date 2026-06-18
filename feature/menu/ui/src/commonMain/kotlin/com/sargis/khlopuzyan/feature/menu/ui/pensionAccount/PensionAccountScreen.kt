package com.sargis.khlopuzyan.feature.menu.ui.pensionAccount

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme

@Composable
fun PensionAccountScreen(
    viewModel: PensionAccountViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    PensionAccountComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun PensionAccountComponent(
    state: PensionAccountState,
    onAction: (PensionAccountAction) -> Unit,
) {

}

@Preview(name = "PensionAccountComponent - Dark", showBackground = true)
@Composable
private fun PensionAccountComponentLightPreview() {
    AppTheme(darkTheme = false) {
        PensionAccountComponent(
            state = PensionAccountState(),
            onAction = {}
        )
    }
}

@Preview(name = "PensionAccountComponent - Dark", showBackground = true)
@Composable
private fun PensionAccountComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        PensionAccountComponent(
            state = PensionAccountState(),
            onAction = {}
        )
    }
}