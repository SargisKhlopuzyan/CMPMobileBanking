package com.sargis.khlopuzyan.feature.main.domain.transactions

data class TransferToCard(
    val status: TransactionStatus,
    val amount: Double,
    val currency: String,
    val transactionNumber: Int,
    override val date: String,
    val country: String,
    val account: String,
    val toCard: String,
    val aim: String,
) : Transaction()