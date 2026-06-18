package com.sargis.khlopuzyan.feature.settings.ui.homePageAppearance

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme

@Composable
fun HomePageAppearanceScreen(
    viewModel: HomePageAppearanceViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    HomePageAppearanceComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun HomePageAppearanceComponent(
    state: HomePageAppearanceState,
    onAction: (HomePageAppearanceAction) -> Unit,
) {

}

@Preview(name = "HomePageAppearanceComponent - Dark", showBackground = true)
@Composable
private fun HomePageAppearanceComponentLightPreview() {
    AppTheme(darkTheme = false) {
        HomePageAppearanceComponent(
            state = HomePageAppearanceState(),
            onAction = {}
        )
    }
}

@Preview(name = "HomePageAppearanceComponent - Dark", showBackground = true)
@Composable
private fun HomePageAppearanceComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        HomePageAppearanceComponent(
            state = HomePageAppearanceState(),
            onAction = {}
        )
    }
}