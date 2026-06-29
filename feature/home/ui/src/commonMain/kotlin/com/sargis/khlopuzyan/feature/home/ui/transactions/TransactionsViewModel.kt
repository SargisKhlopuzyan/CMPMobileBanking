package com.sargis.khlopuzyan.feature.home.ui.transactions

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.MutableStateFlow
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.coroutineScope
import com.rickclephas.kmp.observableviewmodel.launch
import com.sargis.khlopuzyan.core.domain.onError
import com.sargis.khlopuzyan.core.domain.onSuccess
import com.sargis.khlopuzyan.core.ui.LoadingState
import com.sargis.khlopuzyan.core.ui.UiText
import com.sargis.khlopuzyan.feature.home.domain.usecase.GetTransactionsUseCase
import com.sargis.khlopuzyan.feature.home.ui.util.toTransactionListItems
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class TransactionsViewModel(
    private val getTransactionsUseCase: GetTransactionsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(viewModelScope, TransactionsState())

    @NativeCoroutinesState
    val uiState = _uiState.onStart {
        fetchTransactions(LoadingState.LOADING)
    }.stateIn(
        viewModelScope.coroutineScope,
        SharingStarted.WhileSubscribed(5_000L),
        _uiState.value
    )

    fun onAction(action: TransactionsAction) {
        when (action) {
            TransactionsAction.OnStartTransactionsSearch -> startTransactionsSearch()
            is TransactionsAction.OnSearchTransactions -> searchTransactions(action.text)
            TransactionsAction.OnCloseTransactionsSearch -> closeTransactionSearch()
            TransactionsAction.OnRefreshTransactions -> fetchTransactions(LoadingState.REFRESHING)
            is TransactionsAction.OnTransactionClicked -> {
                //TODO-JUST FOR TEST
                _uiState.update { currentState ->
                    currentState.copy(
                        error = null,
                        transactions = emptyList(),
                        filteredTransactions = emptyList()
                    )
                }
            }
            TransactionsAction.OnDismissErrorDialog -> dismissErrorDialog()
        }
    }

    private fun startTransactionsSearch() {
        _uiState.update { currentState ->
            currentState.copy(
                isSearchActive = true,
                searchQuery = "",
                filteredTransactions = currentState.transactions
            )
        }
    }

    private fun closeTransactionSearch() {
        _uiState.update { currentState ->
            currentState.copy(
                isSearchActive = false,
                searchQuery = "",
                filteredTransactions = currentState.transactions
            )
        }
    }

    private fun searchTransactions(search: String) {
        _uiState.update { currentState ->
            currentState.copy(
                searchQuery = search,
                filteredTransactions = currentState.transactions.findMatches(search)
            )
        }
    }

    private fun fetchTransactions(loadingState: LoadingState) {
        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(
                    loadingState = loadingState
                )
            }
            getTransactionsUseCase().onSuccess { transactions ->
                _uiState.update { currentState ->
                    val transactionListItems = transactions.toTransactionListItems()
                    currentState.copy(
                        loadingState = LoadingState.LOADED,
                        error = null,
                        transactions = transactionListItems,
                        filteredTransactions = transactionListItems.findMatches(
                            currentState.searchQuery
                        )
                    )
                }
            }.onError { error ->
                _uiState.update { currentState ->
                    currentState.copy(
                        loadingState = LoadingState.LOADED,
                        error = UiText.DynamicString(error.toString())
                    )
                }
            }
        }
    }

    private fun List<TransactionListItem>.findMatches(query: String): List<TransactionListItem> {
        if (query.isEmpty()) return this
        return this.filter {
            it.title.contains(query, ignoreCase = true) ||
                    it.subtitle.contains(query, ignoreCase = true) ||
                    it.amount.toString().contains(query, ignoreCase = true) ||
                    it.date.contains(query, ignoreCase = true)
        }
    }

    private fun dismissErrorDialog() {
        _uiState.update { currentState ->
            currentState.copy(
                error = null,
                loadingState = LoadingState.LOADED
            )
        }
    }
}