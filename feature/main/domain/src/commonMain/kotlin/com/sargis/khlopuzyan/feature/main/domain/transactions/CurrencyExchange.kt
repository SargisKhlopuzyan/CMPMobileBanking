package com.sargis.khlopuzyan.feature.main.domain.transactions

data class CurrencyExchange(
    val status: TransactionStatus,
    val fromAmount: Double,
    val fromCurrency: String,
    val toAmount: Double,
    val toCurrency: String,
    val commission: String,
    val commissionCurrency: String,
    val transactionNumber: Int,
    override val date: String,
    val fromAccount: String,
    val toAccount: String,
    val rate: String,
    val aim: String
) : Transaction()