package com.sargis.khlopuzyan.feature.settings.ui.sortTemplatesAndGroups

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.designsystem.theme.AppTheme

@Composable
fun SortTemplatesAndGroupsScreen(
    viewModel: SortTemplatesAndGroupsViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    SortTemplatesAndGroupsComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun SortTemplatesAndGroupsComponent(
    state: SortTemplatesAndGroupsState,
    onAction: (SortTemplatesAndGroupsAction) -> Unit,
) {

}

@Preview(name = "SortTemplatesAndGroupsComponent - Dark", showBackground = true)
@Composable
private fun SortTemplatesAndGroupsComponentLightPreview() {
    AppTheme(darkTheme = false) {
        SortTemplatesAndGroupsComponent(
            state = SortTemplatesAndGroupsState(),
            onAction = {}
        )
    }
}

@Preview(name = "SortTemplatesAndGroupsComponent - Dark", showBackground = true)
@Composable
private fun SortTemplatesAndGroupsComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        SortTemplatesAndGroupsComponent(
            state = SortTemplatesAndGroupsState(),
            onAction = {}
        )
    }
}