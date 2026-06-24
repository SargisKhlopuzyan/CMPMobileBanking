package com.sargis.khlopuzyan.feature.home.ui.transactions

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.MutableStateFlow
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.coroutineScope
import com.rickclephas.kmp.observableviewmodel.launch
import com.sargis.khlopuzyan.core.domain.onError
import com.sargis.khlopuzyan.core.domain.onSuccess
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
        getTransactions()
    }.stateIn(
        viewModelScope.coroutineScope,
        SharingStarted.WhileSubscribed(5_000L),
        _uiState.value
    )

    private fun getTransactions() {
        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(isLoading = true)
            }
            getTransactionsUseCase().onSuccess { transactions ->
                _uiState.update { currentState ->
                    currentState.copy(
                        isLoading = false,
                        transactions = transactions.toTransactionListItems()
                    )
                }
            }.onError { error ->
                _uiState.update { currentState ->
                    currentState.copy(
                        isLoading = false,
                        error = UiText.DynamicString(error.toString())
                    )
                }
            }
        }
    }
}