package com.sargis.khlopuzyan.feature.main.domain.transactions

data class UtilityPayment(
    override val transactionNumber: Int,
    override val date: String,
    override val transactionType: TransactionType,
    override val transactionCategory: TransactionCategory = TransactionCategory.UTILITY_PAYMENT,
    override val transactionStatus: TransactionStatus,
    val paymentAmount: Double,
    val paymentAmountCurrency: Currency,
    val commission: Double,
    val commissionCurrency: Currency,
    val account: Int,
    val utility: Utility,
    val customerCodeOrNumber: String,
    val name: String,
    val address: String,
    val dept: Double,
    val deptCurrency: Currency,
) : Transaction()