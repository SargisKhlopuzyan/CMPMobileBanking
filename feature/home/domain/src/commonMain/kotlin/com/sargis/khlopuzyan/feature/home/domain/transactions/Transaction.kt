package com.sargis.khlopuzyan.feature.home.domain.transactions

sealed class Transaction {
    abstract val transactionNumber: Int
    abstract val date: String
    abstract val transactionType: TransactionType
    abstract val transactionStatus: TransactionStatus
    abstract val transactionCategory: TransactionCategory
}