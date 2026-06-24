package com.sargis.khlopuzyan.core.network.api

import com.sargis.khlopuzyan.core.domain.DataError
import com.sargis.khlopuzyan.core.network.dto.TransactionsResponseDto
import com.sargis.khlopuzyan.core.domain.Result

interface RemoteTransactionsDataSource {
    suspend fun getTransactions(): Result<TransactionsResponseDto, DataError.Remote>
}