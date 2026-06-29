package com.sargis.khlopuzyan.feature.home.ui.transactions

import com.sargis.khlopuzyan.core.ui.LoadingState
import com.sargis.khlopuzyan.core.ui.UiText

data class TransactionsState(
    val loadingState: LoadingState = LoadingState.NOT_STARTED,
    val error: UiText? = null,
    val isSearchActive: Boolean = false,
    val searchQuery: String = "",
    val transactions: List<TransactionListItem> = emptyList(),
    val filteredTransactions: List<TransactionListItem> = emptyList(),
)