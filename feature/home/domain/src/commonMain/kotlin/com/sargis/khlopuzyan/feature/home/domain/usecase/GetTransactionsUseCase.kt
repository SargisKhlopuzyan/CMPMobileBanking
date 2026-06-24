package com.sargis.khlopuzyan.feature.home.domain.usecase

import com.sargis.khlopuzyan.core.domain.DataError
import com.sargis.khlopuzyan.core.domain.Result
import com.sargis.khlopuzyan.feature.home.domain.repository.TransactionsRepository
import com.sargis.khlopuzyan.feature.home.domain.model.transactions.Transaction

class GetTransactionsUseCase(
    private val transactionsRepository: TransactionsRepository
) {
    suspend operator fun invoke(): Result<List<Transaction>, DataError> {
        return transactionsRepository.getTransactions()
    }
}