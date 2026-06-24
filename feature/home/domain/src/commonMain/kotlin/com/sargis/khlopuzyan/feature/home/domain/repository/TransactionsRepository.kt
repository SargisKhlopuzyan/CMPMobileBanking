package com.sargis.khlopuzyan.feature.home.domain.repository

import com.sargis.khlopuzyan.core.domain.Result
import com.sargis.khlopuzyan.core.domain.DataError
import com.sargis.khlopuzyan.feature.home.domain.model.transactions.Transaction

interface TransactionsRepository {
    suspend fun getTransactions(): Result<List<Transaction>, DataError>
}