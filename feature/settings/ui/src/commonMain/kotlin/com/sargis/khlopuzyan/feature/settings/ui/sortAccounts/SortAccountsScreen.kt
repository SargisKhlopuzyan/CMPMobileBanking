package com.sargis.khlopuzyan.feature.settings.ui.sortAccounts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme

@Composable
fun SortAccountsScreen(
    viewModel: SortAccountsViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    SortAccountsComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun SortAccountsComponent(
    state: SortAccountsState,
    onAction: (SortAccountsAction) -> Unit,
) {

}

@Preview(name = "SortAccountsComponent - Dark", showBackground = true)
@Composable
private fun SortAccountsComponentLightPreview() {
    AppTheme(darkTheme = false) {
        SortAccountsComponent(
            state = SortAccountsState(),
            onAction = {}
        )
    }
}

@Preview(name = "SortAccountsComponent - Dark", showBackground = true)
@Composable
private fun SortAccountsComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        SortAccountsComponent(
            state = SortAccountsState(),
            onAction = {}
        )
    }
}