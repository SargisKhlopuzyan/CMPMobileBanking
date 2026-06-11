package com.sargis.khlopuzyan.feature.main.domain.transactions

data class TransferToAccount(
    val status: TransactionStatus,
    val amount: Double,
    val currency: String,
    val commission: String,
    val transactionNumber: Int,
    override val date: String,
    val account: String,
    val beneficiaryAccount: String,
    val beneficiaryBank: String,
    val beneficiaryName: String,
    val aim: String,
) : Transaction()