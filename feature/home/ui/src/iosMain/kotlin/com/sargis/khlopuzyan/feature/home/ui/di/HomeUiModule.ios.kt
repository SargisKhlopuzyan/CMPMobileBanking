package com.sargis.khlopuzyan.feature.home.ui.di

import com.sargis.khlopuzyan.feature.home.ui.transactions.TransactionsViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.module.Module
import org.koin.dsl.module

private val transactionsViewModelModule = module {
    single {
        TransactionsViewModel(get())
    }
}

actual fun getHomeUiModule(): Module {
    return transactionsViewModelModule
}

class TransactionsViewModelProvider() : KoinComponent {
    fun provideTransactionsViewModel(): TransactionsViewModel = get()
}