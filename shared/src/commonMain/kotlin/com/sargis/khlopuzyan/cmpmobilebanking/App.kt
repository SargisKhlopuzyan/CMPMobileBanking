package com.sargis.khlopuzyan.cmpmobilebanking

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sargis.khlopuzyan.feature.main.ui.MainScreen
import com.sargis.khlopuzyan.designsystem.theme.AppTheme

@Composable
@Preview
fun App() {
    AppTheme {
//        Column(
//            modifier = Modifier
//                .background(MaterialTheme.colorScheme.primaryContainer)
//                .safeContentPadding()
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
            MainScreen()
//        }
    }
}