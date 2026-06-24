package com.sargis.khlopuzyan.core.database.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.sargis.khlopuzyan.core.database.database.DatabaseFactory
import com.sargis.khlopuzyan.core.database.database.TransactionsDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformDatabaseModule: Module

fun getDatabaseModule() = module {
    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<TransactionsDatabase>().transactionDao }
}