package com.sargis.khlopuzyan.feature.menu.ui.news

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme

@Composable
fun NewsScreen(
    viewModel: NewsViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    NewsComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun NewsComponent(
    state: NewsState,
    onAction: (NewsAction) -> Unit,
) {

}

@Preview(name = "NewsComponent - Dark", showBackground = true)
@Composable
private fun NewsComponentLightPreview() {
    AppTheme(darkTheme = false) {
        NewsComponent(
            state = NewsState(),
            onAction = {}
        )
    }
}

@Preview(name = "NewsComponent - Dark", showBackground = true)
@Composable
private fun NewsComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        NewsComponent(
            state = NewsState(),
            onAction = {}
        )
    }
}