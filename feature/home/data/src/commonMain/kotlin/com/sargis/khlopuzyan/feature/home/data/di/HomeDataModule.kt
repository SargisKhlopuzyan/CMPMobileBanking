package com.sargis.khlopuzyan.feature.home.data.di

import com.sargis.khlopuzyan.feature.home.data.repository.TransactionsRepositoryImpl
import com.sargis.khlopuzyan.feature.home.domain.repository.TransactionsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun getHomeDataModule() = module {
    singleOf(::TransactionsRepositoryImpl).bind<TransactionsRepository>()
}