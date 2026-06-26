package com.sargis.khlopuzyan.feature.home.ui.transactions

sealed class TransactionsAction {
    object OnStartTransactionsSearch : TransactionsAction()
    data class OnSearchTransactions(val text: String) : TransactionsAction()
    object OnCloseTransactionsSearch : TransactionsAction()
    object OnRefreshTransactions : TransactionsAction()
    data class OnTransactionClicked(val id: String) : TransactionsAction()
}