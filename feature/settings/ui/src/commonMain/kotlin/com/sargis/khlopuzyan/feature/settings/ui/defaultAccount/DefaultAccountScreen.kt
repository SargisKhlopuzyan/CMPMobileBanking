package com.sargis.khlopuzyan.feature.settings.ui.defaultAccount

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme

@Composable
fun DefaultAccountScreen(
    viewModel: DefaultAccountViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    DefaultAccountComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun DefaultAccountComponent(
    state: DefaultAccountState,
    onAction: (DefaultAccountAction) -> Unit,
) {

}

@Preview(name = "DefaultAccountComponent - Dark", showBackground = true)
@Composable
private fun DefaultAccountComponentLightPreview() {
    AppTheme(darkTheme = false) {
        DefaultAccountComponent(
            state = DefaultAccountState(),
            onAction = {}
        )
    }
}

@Preview(name = "DefaultAccountComponent - Dark", showBackground = true)
@Composable
private fun DefaultAccountComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        DefaultAccountComponent(
            state = DefaultAccountState(),
            onAction = {}
        )
    }
}