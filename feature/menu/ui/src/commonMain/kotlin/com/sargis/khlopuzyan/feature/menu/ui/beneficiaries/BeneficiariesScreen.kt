package com.sargis.khlopuzyan.feature.menu.ui.beneficiaries

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sargis.khlopuzyan.designsystem.theme.AppTheme

@Composable
fun BeneficiariesScreen(
    viewModel: BeneficiariesViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    BeneficiariesComponent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun BeneficiariesComponent(
    state: BeneficiariesState,
    onAction: (BeneficiariesAction) -> Unit,
) {

}

@Preview(name = "BeneficiariesComponent - Dark", showBackground = true)
@Composable
private fun BeneficiariesComponentLightPreview() {
    AppTheme(darkTheme = false) {
        BeneficiariesComponent(
            state = BeneficiariesState(),
            onAction = {}
        )
    }
}

@Preview(name = "BeneficiariesComponent - Dark", showBackground = true)
@Composable
private fun BeneficiariesComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        BeneficiariesComponent(
            state = BeneficiariesState(),
            onAction = {}
        )
    }
}