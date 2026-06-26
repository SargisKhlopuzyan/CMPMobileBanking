package com.sargis.khlopuzyan.feature.home.data.repository

import com.sargis.khlopuzyan.core.domain.DataError
import com.sargis.khlopuzyan.core.domain.Result
import com.sargis.khlopuzyan.core.fakeDataSource.FakeTransactionsDataSource
import com.sargis.khlopuzyan.core.network.api.KtorRemoteTransactionsDataSource
import com.sargis.khlopuzyan.feature.home.domain.model.transactions.Transaction
import com.sargis.khlopuzyan.feature.home.domain.repository.TransactionsRepository

class TransactionsRepositoryImpl(
    private val remoteTransactionsDataSource: KtorRemoteTransactionsDataSource,
    private val fakeTransactionsDataSource: FakeTransactionsDataSource,
) : TransactionsRepository {
    override suspend fun  getTransactions(): Result<List<Transaction>, DataError> {
        return fakeTransactionsDataSource.getTransactions()
    }
}