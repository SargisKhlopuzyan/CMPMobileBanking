package com.sargis.khlopuzyan.feature.menu.ui.about

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme

@Composable
fun AboutScreen(
    viewModel: AboutViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    AboutComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun AboutComponent(
    state: AboutState,
    onAction: (AboutAction) -> Unit,
) {

}

@Preview(name = "AboutComponent - Dark", showBackground = true)
@Composable
private fun AboutComponentLightPreview() {
    AppTheme(darkTheme = false) {
        AboutComponent(
            state = AboutState(),
            onAction = {}
        )
    }
}

@Preview(name = "AboutComponent - Dark", showBackground = true)
@Composable
private fun AboutComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        AboutComponent(
            state = AboutState(),
            onAction = {}
        )
    }
}