package com.sargis.khlopuzyan.cmpmobilebanking

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.sargis.khlopuzyan.cmpmobilebanking.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CMPMobileBanking",
        ) {
            App()
        }
    }
}