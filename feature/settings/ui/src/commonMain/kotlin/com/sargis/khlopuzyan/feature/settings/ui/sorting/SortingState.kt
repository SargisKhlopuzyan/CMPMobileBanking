package com.sargis.khlopuzyan.feature.settings.ui.sorting

data class SortingState(
    val paramOne: String = "default",
    val paramTwo: List<String> = emptyList(),
)