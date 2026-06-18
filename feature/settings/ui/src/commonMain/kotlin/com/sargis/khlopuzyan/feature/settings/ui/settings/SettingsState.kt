package com.sargis.khlopuzyan.feature.settings.ui.settings

data class SettingsState(
    val paramOne: String = "default",
    val paramTwo: List<String> = emptyList(),
)