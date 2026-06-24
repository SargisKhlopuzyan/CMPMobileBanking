package com.sargis.khlopuzyan.core.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class TransactionDto (
    val transactionNumber: Int,
    val date: String
//    val transactionType: TransactionType
//    val transactionStatus: TransactionStatus
//    val transactionCategory: TransactionCategory
)