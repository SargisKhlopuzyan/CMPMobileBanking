package com.sargis.khlopuzyan.feature.home.ui.transactions

import com.sargis.khlopuzyan.core.ui.UiText

data class TransactionsState(
    val isRefreshing: Boolean = false,
    val error: UiText? = null,
    val isSearchActive: Boolean = false,
    val searchQuery: String = "",
    val transactions: List<TransactionListItem> = emptyList(),
    val filteredTransactions: List<TransactionListItem> = emptyList(),
)