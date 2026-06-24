package com.sargis.khlopuzyan.feature.home.domain.model.transactions

data class PoliceAdministrativeFine(
    override val transactionNumber: Int,
    override val date: String,
    override val transactionType: TransactionType,
    override val transactionCategory: TransactionCategory,
    override val transactionStatus: TransactionStatus,
    val amount: Double,
    val currency: Currency,
    val commission: String,
    val decreeNumber: Int,
    val fullName: String,
    val beneficiaryAccount: String,
    val beneficiaryName: String,
    val fromAccount: String,
    val debt: String,
    val aim: String,
) : Transaction()