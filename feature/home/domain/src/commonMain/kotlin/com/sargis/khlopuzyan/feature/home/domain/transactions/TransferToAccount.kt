package com.sargis.khlopuzyan.feature.home.domain.transactions

data class TransferToAccount(
    override val transactionNumber: Int,
    override val date: String,
    override val transactionType: TransactionType,
    override val transactionCategory: TransactionCategory,
    override val transactionStatus: TransactionStatus,
    val amount: Double,
    val currency: Currency,
    val commission: String,
    val account: String,
    val beneficiaryAccount: String,
    val beneficiaryBank: String,
    val beneficiaryName: String,
    val aim: String,
) : Transaction()