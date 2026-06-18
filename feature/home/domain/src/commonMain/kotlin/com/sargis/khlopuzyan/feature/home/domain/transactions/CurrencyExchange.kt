package com.sargis.khlopuzyan.feature.home.domain.transactions

data class CurrencyExchange(
    override val transactionNumber: Int,
    override val date: String,
    override val transactionType: TransactionType,
    override val transactionCategory: TransactionCategory,
    override val transactionStatus: TransactionStatus,
    val fromAmount: Double,
    val fromCurrency: Currency,
    val toAmount: Double,
    val toCurrency: Currency,
    val commission: String,
    val commissionCurrency: Currency,
    val fromAccount: String,
    val toAccount: String,
    val rate: String,
    val aim: String
) : Transaction()