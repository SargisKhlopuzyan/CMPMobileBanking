package com.sargis.khlopuzyan.core.fakeDataSource.di

import com.sargis.khlopuzyan.core.fakeDataSource.FakeTransactionsDataSource
import org.koin.dsl.module

fun getFakeModule() = module {
    single {
        FakeTransactionsDataSource
    }
}