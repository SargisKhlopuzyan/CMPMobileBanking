package com.sargis.khlopuzyan.feature.main.ui.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.designsystem.button.SelectableButton
import com.sargis.khlopuzyan.designsystem.component.EmptyResultComponent
import com.sargis.khlopuzyan.designsystem.resources.SharedRes
import com.sargis.khlopuzyan.designsystem.resources.transactions
import com.sargis.khlopuzyan.designsystem.theme.AppTheme
import com.sargis.khlopuzyan.designsystem.theme.Transparent
import com.sargis.khlopuzyan.feature.main.domain.mock.mockTransactions
import com.sargis.khlopuzyan.feature.main.ui.util.toTransactionListItem
import org.jetbrains.compose.resources.stringResource

@Composable
fun TransactionsScreen() {
    val transactions = mockTransactions

    val transactionListItem = transactions.map { transaction ->
        transaction.toTransactionListItem()
    }

    TransactionsScreenComponent(
        onSearchTriggered = {},
        transactionListItem
    )
}

@Composable
fun TransactionsScreenComponent(
    onSearchTriggered: (Boolean) -> Unit,
    transactions: List<TransactionListItem>
) {
    var isSearchActive by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    val filteredTransactions = remember { mutableStateListOf<TransactionListItem>() }

    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        filteredTransactions.clear()
        filteredTransactions.addAll(transactions)
    }

    LaunchedEffect(isSearchActive) {
        focusRequester.requestFocus()
    }

    Scaffold(
        topBar = {
            Surface(
                shadowElevation = 8.dp, // Adjust depth here
                tonalElevation = 0.dp   // Disables M3 color tinting if preferred
            ) {
                TopAppBar(
                    title = {
                        if (isSearchActive) {
                            TextField(
                                value = searchQuery,
                                onValueChange = {
                                    searchQuery = it
                                    filteredTransactions.clear()
                                    filteredTransactions.addAll(transactions.findMatches(it))
                                },
                                textStyle = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.fillMaxWidth()
                                    .focusRequester(focusRequester),
                                placeholder = { Text("Search...") },
                                leadingIcon = null,
                                trailingIcon = {
                                    if (searchQuery.isNotEmpty()) {
                                        IconButton(onClick = {
                                            searchQuery = ""
                                            filteredTransactions.clear()
                                            filteredTransactions.addAll(transactions)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Close,
                                                contentDescription = "Clear Search",
                                                modifier = Modifier.size(24.dp)
                                            )
                                        }
                                    }
                                },
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Transparent,
                                    unfocusedContainerColor = Transparent,
                                    disabledContainerColor = Transparent,
                                    focusedIndicatorColor = Transparent,
                                    unfocusedIndicatorColor = Transparent,
                                ),
                                singleLine = true
                            )
                        } else {
                            Text(
                                text = stringResource(SharedRes.string.transactions),
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            if (isSearchActive) {
                                isSearchActive = false
                                onSearchTriggered(false)
                                searchQuery = ""
                                filteredTransactions.clear()
                                filteredTransactions.addAll(transactions)
                            } else {
                                // Handle back navigation if needed
                            }
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                contentDescription = "Back",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    },
                    actions = {
                        if (!isSearchActive) {
                            IconButton(onClick = {
                                isSearchActive = true
                                focusRequester.requestFocus()
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                        IconButton(onClick = {

                        }) {
                            Icon(
                                imageVector = Icons.Default.FilterList,
                                contentDescription = "Filter",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors().copy(
                        containerColor = MaterialTheme.colorScheme.surface,
                        titleContentColor = MaterialTheme.colorScheme.onSurface,
                        navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
                        actionIconContentColor = MaterialTheme.colorScheme.onSurface
                    )
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                //.safeContentPadding()
                .padding(it)
                .fillMaxSize()
        ) {
            SelectableButton(
                text = "Current month",
                selected = true,
                modifier = Modifier.wrapContentSize().padding(horizontal = 12.dp, vertical = 12.dp),
                onClick = { }
            )

            if (filteredTransactions.isNotEmpty()) {
                CategorizedTransactionsList(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                    transactions = filteredTransactions
                )
            } else {
                EmptyResultComponent(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

fun List<TransactionListItem>.findMatches(query: String): List<TransactionListItem> {
    return this.filter {
        it.title.contains(query, ignoreCase = true) ||
                it.subtitle.contains(query, ignoreCase = true)
    }
}

@Preview(showBackground = true)
@Composable
private fun TransactionsScreenComponentPreview() {
    AppTheme {
        TransactionsScreenComponent(
            onSearchTriggered = {},
            transactions = mockTransactions.map {
                it.toTransactionListItem()
            }
        )
    }
}

@Preview(name = "TransactionsScreen - Dark", showBackground = true)
@Composable
private fun TransactionsScreenComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        TransactionsScreenComponent(
            onSearchTriggered = {},
            transactions = mockTransactions.map {
                it.toTransactionListItem()
            }
        )
    }
}

