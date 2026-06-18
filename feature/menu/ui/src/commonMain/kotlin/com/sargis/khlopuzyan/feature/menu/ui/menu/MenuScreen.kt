package com.sargis.khlopuzyan.feature.menu.ui.menu

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.designsystem.theme.AppTheme

@Composable
fun MenuScreen(
    viewModel: MenuViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    MenuComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun MenuComponent(
    state: MenuState,
    onAction: (MenuAction) -> Unit,
) {

}

@Preview(name = "MenuComponent - Dark", showBackground = true)
@Composable
private fun MenuComponentLightPreview() {
    AppTheme(darkTheme = false) {
        MenuComponent(
            state = MenuState(),
            onAction = {}
        )
    }
}

@Preview(name = "MenuComponent - Dark", showBackground = true)
@Composable
private fun MenuComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        MenuComponent(
            state = MenuState(),
            onAction = {}
        )
    }
}