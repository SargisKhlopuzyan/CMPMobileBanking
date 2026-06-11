package com.sargis.khlopuzyan.feature.main.domain.transactions

data class PoliceAdministrativeFine(
    val status: TransactionStatus,
    val amount: Double,
    val currency: String,
    val commission: String,
    val transactionNumber: Int,
    override val date: String,
    val decreeNumber: Int,
    val fullName: String,
    val beneficiaryAccount: String,
    val beneficiaryName: String,
    val fromAccount: String,
    val debt: String,
    val aim: String,
) : Transaction()