package com.sargis.khlopuzyan.core.network.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.dsl.module

actual val platformNetworkModule: org.koin.core.module.Module
    get() = module {
        single<HttpClientEngine> { OkHttp.create() }
    }