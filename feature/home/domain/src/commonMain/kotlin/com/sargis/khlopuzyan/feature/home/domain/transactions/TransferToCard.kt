package com.sargis.khlopuzyan.feature.home.domain.transactions

data class TransferToCard(
    override val transactionNumber: Int,
    override val date: String,
    override val transactionType: TransactionType,
    override val transactionCategory: TransactionCategory,
    override val transactionStatus: TransactionStatus,
    val amount: Double,
    val currency: Currency,
    val country: String,
    val account: String,
    val toCard: String,
    val aim: String,
) : Transaction()