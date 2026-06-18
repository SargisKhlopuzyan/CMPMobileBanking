package com.sargis.khlopuzyan.feature.settings.ui.defaultAccount

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class DefaultAccountViewModel : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(DefaultAccountState())
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
            initialValue = DefaultAccountState()
        )

    fun onAction(action: DefaultAccountAction) {
        when (action) {
            else -> TODO("Handle actions")
        }
    }

}