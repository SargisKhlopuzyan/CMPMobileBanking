package com.sargis.khlopuzyan.feature.home.ui.di

import com.sargis.khlopuzyan.feature.home.ui.transactions.TransactionsViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

actual fun getHomeUiModule(): Module {
    return module {
        viewModel {
            TransactionsViewModel(get())
        }
    }
}