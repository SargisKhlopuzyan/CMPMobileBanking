package com.sargis.khlopuzyan.core.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class TransactionsResponseDto(
    val results: List<TransactionDto>,
) {
}