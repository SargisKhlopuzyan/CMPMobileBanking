package com.sargis.khlopuzyan.feature.menu.ui.incomeDeclarationReference

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class IncomeDeclarationReferenceViewModel : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(IncomeDeclarationReferenceState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                /** Load initial data here **/
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = IncomeDeclarationReferenceState()
        )

    fun onAction(action: IncomeDeclarationReferenceAction) {
        when (action) {
            else -> TODO("Handle actions")
        }
    }

}