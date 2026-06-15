package com.sargis.khlopuzyan.feature.main.ui.transactions

import com.sargis.khlopuzyan.feature.main.domain.transactions.Currency
import com.sargis.khlopuzyan.feature.main.domain.transactions.TransactionCategory
import com.sargis.khlopuzyan.feature.main.domain.transactions.TransactionStatus
import com.sargis.khlopuzyan.feature.main.domain.transactions.TransactionType
import org.jetbrains.compose.resources.DrawableResource

data class TransactionListItem(
    val iconRes: DrawableResource,
    val transactionNumber: Int,
    val date: String,
    val title: String,
    val subtitle: String,
    val amount: Double,
    val currency: Currency,
    val transactionType: TransactionType,
    val transactionStatus: TransactionStatus,
    val transactionCategory: TransactionCategory,
)