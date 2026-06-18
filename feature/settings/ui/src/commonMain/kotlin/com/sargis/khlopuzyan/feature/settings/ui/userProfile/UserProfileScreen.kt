package com.sargis.khlopuzyan.feature.settings.ui.userProfile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme

@Composable
fun UserProfileScreen(
    viewModel: UserProfileViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    UserProfileComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun UserProfileComponent(
    state: UserProfileState,
    onAction: (UserProfileAction) -> Unit,
) {

}

@Preview(name = "UserProfileComponent - Dark", showBackground = true)
@Composable
private fun UserProfileComponentLightPreview() {
    AppTheme(darkTheme = false) {
        UserProfileComponent(
            state = UserProfileState(),
            onAction = {}
        )
    }
}

@Preview(name = "UserProfileComponent - Dark", showBackground = true)
@Composable
private fun UserProfileComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        UserProfileComponent(
            state = UserProfileState(),
            onAction = {}
        )
    }
}