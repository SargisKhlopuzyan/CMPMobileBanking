package com.sargis.khlopuzyan.cmpmobilebanking.di

import com.sargis.khlopuzyan.core.database.di.getDatabaseModule
import com.sargis.khlopuzyan.core.database.di.platformDatabaseModule
import com.sargis.khlopuzyan.core.fakeDataSource.di.getFakeModule
import com.sargis.khlopuzyan.core.network.di.getNetworkModule
import com.sargis.khlopuzyan.core.network.di.platformNetworkModule
import com.sargis.khlopuzyan.feature.home.data.di.getHomeDataModule
import com.sargis.khlopuzyan.feature.home.domain.di.getHomeDomainModule
import com.sargis.khlopuzyan.feature.home.ui.di.getHomeUiModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            getFakeModule(),
            platformDatabaseModule,
            platformNetworkModule,
            getDatabaseModule(),
            getNetworkModule(),

            getHomeDataModule(),
            getHomeDomainModule(),
            getHomeUiModule(),
        )
    }
}