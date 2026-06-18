package com.sargis.khlopuzyan.feature.home.ui.transactions

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CategorizedTransactionsList(
    modifier: Modifier = Modifier,
    transactions: List<TransactionListItem>,
) {
    LazyColumn(modifier) {
        transactions.sortedBy {
            it.date
        }.groupBy {
            it.date
        }.forEach { (date, transactions) ->
            stickyHeader {
                TransactionHeader(
                    text = date
                )
            }
            items(transactions) { transaction ->
                TransactionItem(
                    modifier = Modifier.fillParentMaxWidth(),
                    isDarkTheme = isSystemInDarkTheme(),
                    transactionListItem = transaction,
                )
            }
        }
    }
}