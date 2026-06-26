package com.sargis.khlopuzyan.feature.home.ui.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sargis.khlopuzyan.core.designsystem.button.SelectableButton
import com.sargis.khlopuzyan.core.designsystem.component.InfoComponent
import com.sargis.khlopuzyan.core.designsystem.resources.SharedRes
import com.sargis.khlopuzyan.core.designsystem.resources.transactions
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme
import com.sargis.khlopuzyan.core.designsystem.theme.Transparent
import com.sargis.khlopuzyan.core.fakeDataSource.FakeTransactionsDataSource
import com.sargis.khlopuzyan.feature.home.ui.util.toTransactionListItem
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TransactionsScreen() {
    val viewModel = koinViewModel<TransactionsViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    TransactionsScreenComponent(
        uiState,
        onAction = viewModel::onAction
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionsScreenComponent(
    uiState: TransactionsState,
    onAction: (TransactionsAction) -> Unit = {}
) {
    val pullToRefreshState = rememberPullToRefreshState()
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(uiState.isSearchActive) {
        if (uiState.isSearchActive) {
            focusRequester.requestFocus()
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Surface(
                shadowElevation = 8.dp, // Adjust depth here
                tonalElevation = 0.dp   // Disables M3 color tinting if preferred
            ) {
                TopAppBar(
                    title = {
                        if (uiState.isSearchActive) {
                            TextField(
                                value = uiState.searchQuery,
                                onValueChange = {
                                    onAction(TransactionsAction.OnSearchTransactions(it))
                                },
                                textStyle = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.fillMaxWidth()
                                    .focusRequester(focusRequester),
                                placeholder = { Text("Search...") },
                                leadingIcon = null,
                                trailingIcon = {
                                    if (uiState.searchQuery.isNotEmpty()) {
                                        IconButton(onClick = {
                                            onAction(TransactionsAction.OnSearchTransactions("")) // Clear the search query
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
                            if (uiState.isSearchActive) {
                                onAction(TransactionsAction.OnCloseTransactionsSearch)
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
                        if (!uiState.isSearchActive) {
                            IconButton(onClick = {
                                onAction(TransactionsAction.OnStartTransactionsSearch)
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
        PullToRefreshBox(
            modifier = Modifier
                //.safeContentPadding()
                .padding(it)
                .fillMaxSize(),
            isRefreshing = uiState.isRefreshing,
            state = pullToRefreshState,
            onRefresh = {
                onAction(TransactionsAction.OnRefreshTransactions)
            },
        ) {
            Column(
                modifier = Modifier
                    //.padding(it)
                    .fillMaxSize()
            ) {
                SelectableButton(
                    text = "Current month",
                    selected = true,
                    modifier = Modifier.wrapContentSize()
                        .padding(horizontal = 12.dp, vertical = 12.dp),
                    onClick = { }
                )

                if (uiState.filteredTransactions.isEmpty()) {
                    if (uiState.error != null) {
                        InfoComponent(
                            content = {
                                Text(
                                    text = uiState.error.asString(),
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        )
                    } else {
                        InfoComponent()
                    }
                } else {

                    if (uiState.error != null) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            CategorizedTransactionsList(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(MaterialTheme.colorScheme.background),
                                transactions = uiState.filteredTransactions,
                                onItemClick = { transaction ->
                                    onAction(TransactionsAction.OnTransactionClicked(transaction.transactionNumber))
                                }
                            )
                            AlertDialog(
                                onDismissRequest = {

                                },
                                text = { Text(uiState.error.asString()) },
                                confirmButton = {
                                    TextButton(onClick = {
                                        onAction(TransactionsAction.OnDismissErrorDialog)
                                    }) {
                                        Text("Ok")
                                    }
                                }
                            )
                        }
                    } else {
                        CategorizedTransactionsList(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colorScheme.background),
                            transactions = uiState.filteredTransactions,
                            onItemClick = { transaction ->
                                onAction(TransactionsAction.OnTransactionClicked(transaction.transactionNumber))
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TransactionsScreenComponentPreview() {
    AppTheme {
        TransactionsScreenComponent(
            uiState = TransactionsState(
                transactions = runBlocking {
                    FakeTransactionsDataSource.generateFakeTransactions().map {
                        it.toTransactionListItem()
                    }
                }
            )
        )
    }
}

@Preview(name = "TransactionsScreen - Dark", showBackground = true)
@Composable
private fun TransactionsScreenComponentDarkPreview() {
    AppTheme(darkTheme = true) {
        TransactionsScreenComponent(
            uiState = TransactionsState(
                transactions = runBlocking {
                    FakeTransactionsDataSource.generateFakeTransactions().map {
                        it.toTransactionListItem()
                    }
                }
            )
        )
    }
}