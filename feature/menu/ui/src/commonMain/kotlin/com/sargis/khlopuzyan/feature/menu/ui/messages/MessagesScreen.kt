package com.sargis.khlopuzyan.feature.menu.ui.messages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.designsystem.theme.AppTheme

@Composable
fun MessagesScreen(
    viewModel: MessagesViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    MessagesComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun MessagesComponent(
    state: MessagesState,
    onAction: (MessagesAction) -> Unit,
) {

}

@Preview(name = "MessagesComponent - Dark", showBackground = true)
@Composable
private fun MessagesComponentLightPreview() {
    AppTheme(darkTheme = false) {
        MessagesComponent(
            state = MessagesState(),
            onAction = {}
        )
    }
}

@Preview(name = "MessagesComponent - Dark", showBackground = true)
@Composable
private fun MessagesComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        MessagesComponent(
            state = MessagesState(),
            onAction = {}
        )
    }
}