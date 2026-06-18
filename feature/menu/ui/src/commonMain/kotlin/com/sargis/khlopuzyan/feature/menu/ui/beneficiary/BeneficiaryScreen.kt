package com.sargis.khlopuzyan.feature.menu.ui.beneficiary

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.designsystem.theme.AppTheme

@Composable
fun BeneficiaryScreen(
    viewModel: BeneficiaryViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    BeneficiaryComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun BeneficiaryComponent(
    state: BeneficiaryState,
    onAction: (BeneficiaryAction) -> Unit,
) {

}

@Preview(name = "BeneficiaryComponent - Dark", showBackground = true)
@Composable
private fun BeneficiaryComponentLightPreview() {
    AppTheme(darkTheme = false) {
        BeneficiaryComponent(
            state = BeneficiaryState(),
            onAction = {}
        )
    }
}

@Preview(name = "BeneficiaryComponent - Dark", showBackground = true)
@Composable
private fun BeneficiaryComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        BeneficiaryComponent(
            state = BeneficiaryState(),
            onAction = {}
        )
    }
}