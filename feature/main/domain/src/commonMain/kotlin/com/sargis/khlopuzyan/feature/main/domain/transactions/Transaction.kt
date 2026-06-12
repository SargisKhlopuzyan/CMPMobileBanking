package com.sargis.khlopuzyan.feature.main.domain.transactions

sealed class Transaction(
    transactionType: TransactionType,
    transactionStatus: TransactionStatus,
    transactionCategory: TransactionCategory,
    open val date: String = ""
)