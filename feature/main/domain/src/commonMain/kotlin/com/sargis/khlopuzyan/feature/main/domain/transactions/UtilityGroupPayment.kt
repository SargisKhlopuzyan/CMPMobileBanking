package com.sargis.khlopuzyan.feature.main.domain.transactions

data class UtilityGroupPayment(
    override val transactionNumber: Int,
    override val date: String,
    override val transactionType: TransactionType,
    override val transactionCategory: TransactionCategory = TransactionCategory.UTILITY_GROUP_PAYMENT,
    override val transactionStatus: TransactionStatus,
    val fromAccount: String,
    val aim: String,
    val fromAmount: Double,
    val utilityPayments: List<UtilityPayment>
) : Transaction()