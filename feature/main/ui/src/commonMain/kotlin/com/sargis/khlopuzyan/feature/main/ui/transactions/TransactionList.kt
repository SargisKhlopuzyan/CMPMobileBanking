package com.sargis.khlopuzyan.feature.main.ui.transactions

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sargis.khlopuzyan.designsystem.resources.SharedRes
import com.sargis.khlopuzyan.designsystem.resources.compose_multiplatform
import com.sargis.khlopuzyan.feature.main.domain.transactions.CurrencyExchange
import com.sargis.khlopuzyan.feature.main.domain.transactions.PoliceAdministrativeFine
import com.sargis.khlopuzyan.feature.main.domain.transactions.Transaction
import com.sargis.khlopuzyan.feature.main.domain.transactions.TransactionStatus
import com.sargis.khlopuzyan.feature.main.domain.transactions.TransferToAccount
import com.sargis.khlopuzyan.feature.main.domain.transactions.TransferToCard
import com.sargis.khlopuzyan.feature.main.ui.util.getTransactionName
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun CategorizedTransactionsList(
    modifier: Modifier = Modifier,
    transactions: List<Transaction>,
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
                var iconRes: DrawableResource
                var amount = 0.0
                var currency = ""
                var status: TransactionStatus = TransactionStatus.CONFIRMED
                var title: String
                var subTitle: String
                when (transaction) {
                    is CurrencyExchange -> {
                        iconRes = SharedRes.drawable.compose_multiplatform
                        title = transaction.aim
                        subTitle = transaction.aim
                        amount = transaction.toAmount
                        currency = transaction.toCurrency
                        status = transaction.status
                    }
                    is PoliceAdministrativeFine -> {
                        iconRes = SharedRes.drawable.compose_multiplatform
                        title = transaction.aim
                        subTitle = transaction.beneficiaryName
                        amount = transaction.amount
                        currency = transaction.currency
                        status = transaction.status
                    }
                    is TransferToAccount -> {
                        iconRes = SharedRes.drawable.compose_multiplatform
                        title = transaction.aim
                        subTitle = transaction.beneficiaryName
                        amount = transaction.amount
                        currency = transaction.currency
                        status = transaction.status
                    }
                    is TransferToCard -> {
                        iconRes = SharedRes.drawable.compose_multiplatform
                        title = transaction.aim
                        subTitle = stringResource(transaction.getTransactionName())
                        amount = transaction.amount
                        currency = transaction.currency
                        status = transaction.status
                    }
                }
                TransactionItem(
                    modifier = Modifier.fillParentMaxWidth(),
                    iconRes = iconRes,
                    isDarkTheme = isSystemInDarkTheme(),
                    title = title,
                    subTitle = subTitle,
                    amount = amount.toString(),
                    currency = currency,
                    status = status
                )
            }
        }
    }
}