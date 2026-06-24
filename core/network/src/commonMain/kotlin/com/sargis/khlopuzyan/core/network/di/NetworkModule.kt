package com.sargis.khlopuzyan.core.network.di

import com.sargis.khlopuzyan.core.network.api.KtorRemoteTransactionsDataSource
import com.sargis.khlopuzyan.core.network.api.RemoteTransactionsDataSource
import com.sargis.khlopuzyan.core.network.client.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformNetworkModule: Module

fun getNetworkModule() = module {
    single {
        HttpClientFactory.create(get())
    }
    //    singleOf(::KtorRemoteTransactionsDataSource)
    singleOf(::KtorRemoteTransactionsDataSource).bind<RemoteTransactionsDataSource>()
}