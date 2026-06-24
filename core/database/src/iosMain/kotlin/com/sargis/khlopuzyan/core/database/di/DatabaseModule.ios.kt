package com.sargis.khlopuzyan.core.database.di

import com.sargis.khlopuzyan.core.database.database.DatabaseFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformDatabaseModule: Module
    get() = module {
        single { DatabaseFactory() }
    }