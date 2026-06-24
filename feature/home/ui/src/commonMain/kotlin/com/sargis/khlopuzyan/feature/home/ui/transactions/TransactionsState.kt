package com.sargis.khlopuzyan.feature.home.ui.transactions

import com.sargis.khlopuzyan.core.ui.UiText

data class TransactionsState(
    val isLoading: Boolean = false,
    val error: UiText? = null,
    val transactions: List<TransactionListItem> = emptyList(),
)