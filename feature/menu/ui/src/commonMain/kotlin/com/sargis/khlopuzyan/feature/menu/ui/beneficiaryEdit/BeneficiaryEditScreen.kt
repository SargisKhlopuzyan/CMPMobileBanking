package com.sargis.khlopuzyan.feature.menu.ui.beneficiaryEdit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.designsystem.theme.AppTheme

@Composable
fun BeneficiaryEditScreen(
    viewModel: BeneficiaryEditViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    BeneficiaryEditComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun BeneficiaryEditComponent(
    state: BeneficiaryEditState,
    onAction: (BeneficiaryEditAction) -> Unit,
) {

}

@Preview(name = "BeneficiaryEditComponent - Dark", showBackground = true)
@Composable
private fun BeneficiaryEditComponentLightPreview() {
    AppTheme(darkTheme = false) {
        BeneficiaryEditComponent(
            state = BeneficiaryEditState(),
            onAction = {}
        )
    }
}

@Preview(name = "BeneficiaryEditComponent - Dark", showBackground = true)
@Composable
private fun BeneficiaryEditComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        BeneficiaryEditComponent(
            state = BeneficiaryEditState(),
            onAction = {}
        )
    }
}