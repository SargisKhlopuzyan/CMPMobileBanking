package com.sargis.khlopuzyan.feature.settings.ui.sortAccounts

data class SortAccountsState(
    val paramOne: String = "default",
    val paramTwo: List<String> = emptyList(),
)