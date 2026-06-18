package com.sargis.khlopuzyan.feature.home.ui.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.core.designsystem.checkbox.RoundedCheckbox
import com.sargis.khlopuzyan.core.designsystem.icon.RoundedIcon
import com.sargis.khlopuzyan.core.designsystem.resources.SharedRes
import com.sargis.khlopuzyan.core.designsystem.resources.compose_multiplatform
import com.sargis.khlopuzyan.core.designsystem.theme.AppTheme
import com.sargis.khlopuzyan.core.designsystem.theme.Green
import com.sargis.khlopuzyan.core.designsystem.theme.Grey
import com.sargis.khlopuzyan.core.designsystem.theme.Red
import com.sargis.khlopuzyan.core.designsystem.unit.formatAsAmount
import com.sargis.khlopuzyan.feature.home.domain.transactions.Currency
import com.sargis.khlopuzyan.feature.home.domain.transactions.TransactionCategory
import com.sargis.khlopuzyan.feature.home.domain.transactions.TransactionStatus
import com.sargis.khlopuzyan.feature.home.domain.transactions.TransactionType
import com.sargis.khlopuzyan.feature.home.ui.util.isConfirmed
import com.sargis.khlopuzyan.feature.home.ui.util.localizedRes
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun TransactionItem(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean = false,
    selectable: Boolean = true,
    isSelectMode: Boolean = false,
    isSelected: Boolean = true,
    transactionListItem: TransactionListItem,
    onCheckedChange: (isChecked: Boolean) -> Unit = { },
    onItemClick: () -> Unit = { },
    onItemLongClick: () -> Unit = { }
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(MaterialTheme.colorScheme.background)
            .combinedClickable(
                onClick = onItemClick,
                onLongClick = onItemLongClick
            )
            .padding(start = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (selectable && isSelectMode) {
            RoundedCheckbox(
                checked = isSelected,
                onCheckedChange = onCheckedChange
            )

            Spacer(modifier = Modifier.width(12.dp))
        }

        RoundedIcon(
            painter = painterResource(transactionListItem.iconRes),
            isDarkTheme = isDarkTheme,
            contentDescription = null,
            size = 42.dp,
            cornerRadius = 8.dp,
            borderColor = Grey,
            borderWidth = 0.5.dp
        )

        Spacer(modifier = Modifier.width(12.dp))

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            Row(
                modifier = Modifier.fillMaxSize().padding(end = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    modifier = Modifier.wrapContentHeight().weight(1f)
                        .padding(end = 4.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.wrapContentHeight().fillMaxWidth(),
                        text = transactionListItem.title,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        modifier = Modifier.wrapContentHeight().fillMaxWidth(),
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        text = transactionListItem.subtitle,
                        color = Grey
                    )
                }
                Column(
                    modifier = Modifier.wrapContentSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "${transactionListItem.amount.formatAsAmount()} ${transactionListItem.currency.name}",
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 1,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = stringResource(transactionListItem.transactionStatus.localizedRes()),
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        color = if (transactionListItem.transactionStatus.isConfirmed()) Green else Red
                    )
                }
            }

            HorizontalDivider(thickness = 0.3.dp, color = Grey)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TransactionItemPreview() {
    AppTheme {
        TransactionItem(
            transactionListItem = TransactionListItem(
                iconRes = SharedRes.drawable.compose_multiplatform,
                transactionNumber = 123456789,
                date = "12.12.2023",
                title = "Transfer to Card",
                subtitle = "Sargis Khlopuzyan",
                amount = 120.0,
                currency = Currency.AMD,
                transactionType = TransactionType.TRANSFERS,
                transactionStatus = TransactionStatus.CONFIRMED,
                transactionCategory = TransactionCategory.TRANSFER_TO_CARD
            ),
            isDarkTheme = false
        )
    }
}

@Preview(name = "TransactionsItem - Dark", showBackground = true)
@Composable
private fun TransactionItemDarkPreview() {
    AppTheme(darkTheme = true) {
        TransactionItem(
            transactionListItem = TransactionListItem(
                iconRes = SharedRes.drawable.compose_multiplatform,
                transactionNumber = 123456789,
                date = "12.12.2023",
                title = "Transfer to Card",
                subtitle = "Sargis Khlopuzyan",
                amount = 120.0,
                currency = Currency.AMD,
                transactionType = TransactionType.TRANSFERS,
                transactionStatus = TransactionStatus.CONFIRMED,
                transactionCategory = TransactionCategory.TRANSFER_TO_CARD
            ),
            isDarkTheme = true
        )
    }
}