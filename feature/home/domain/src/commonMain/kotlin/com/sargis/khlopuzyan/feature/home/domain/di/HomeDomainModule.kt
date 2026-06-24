package com.sargis.khlopuzyan.feature.home.domain.di

import com.sargis.khlopuzyan.feature.home.domain.usecase.GetTransactionsUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun getHomeDomainModule(): Module {
    return module {
        // single
        factory {
            GetTransactionsUseCase(get())
        }
    }
}