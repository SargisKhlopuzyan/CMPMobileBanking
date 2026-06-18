package com.sargis.khlopuzyan.feature.menu.ui.incomeDeclarationReference

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.designsystem.theme.AppTheme

@Composable
fun IncomeDeclarationReferenceScreen(
    viewModel: IncomeDeclarationReferenceViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    IncomeDeclarationReferenceComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun IncomeDeclarationReferenceComponent(
    state: IncomeDeclarationReferenceState,
    onAction: (IncomeDeclarationReferenceAction) -> Unit,
) {

}

@Preview(name = "IncomeDeclarationReferenceComponent - Dark", showBackground = true)
@Composable
private fun IncomeDeclarationReferenceComponentLightPreview() {
    AppTheme(darkTheme = false) {
        IncomeDeclarationReferenceComponent(
            state = IncomeDeclarationReferenceState(),
            onAction = {}
        )
    }
}

@Preview(name = "IncomeDeclarationReferenceComponent - Dark", showBackground = true)
@Composable
private fun IncomeDeclarationReferenceComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        IncomeDeclarationReferenceComponent(
            state = IncomeDeclarationReferenceState(),
            onAction = {}
        )
    }
}