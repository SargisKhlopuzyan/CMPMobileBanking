package com.sargis.khlopuzyan.feature.main.ui.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.designsystem.checkbox.RoundedCheckbox
import com.sargis.khlopuzyan.designsystem.icon.RoundedIcon
import com.sargis.khlopuzyan.designsystem.resources.SharedRes
import com.sargis.khlopuzyan.designsystem.resources.compose_multiplatform
import com.sargis.khlopuzyan.designsystem.theme.AppTheme
import com.sargis.khlopuzyan.designsystem.theme.Green
import com.sargis.khlopuzyan.designsystem.theme.Grey
import com.sargis.khlopuzyan.designsystem.theme.LightGrey
import com.sargis.khlopuzyan.designsystem.theme.Red
import com.sargis.khlopuzyan.feature.main.domain.transactions.TransactionStatus
import com.sargis.khlopuzyan.feature.main.ui.util.isConfirmed
import com.sargis.khlopuzyan.feature.main.ui.util.localizedRes
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun TransactionItem(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean = false,
    selectable: Boolean = true,
    isSelectMode: Boolean = false,
    isSelected: Boolean = true,
    iconRes: DrawableResource,
    title: String,
    subTitle: String,
    amount: String,
    currency: String,
    status: TransactionStatus,
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
            painter = painterResource(iconRes),
            isDarkTheme = isDarkTheme,
            contentDescription = null,
            size = 40.dp,
            cornerRadius = 8.dp,
            borderColor = Grey,
            borderWidth = 0.dp
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().weight(1f).padding(end = 12.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Row {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = title,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = "$amount $currency",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                Row {
                    Text(
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.bodySmall,
                        text = subTitle,
                        color = LightGrey
                    )
                    Text(
                        text = stringResource(status.localizedRes()),
                        style = MaterialTheme.typography.bodySmall,
                        color = if (status.isConfirmed()) Green else Red
                    )
                }
            }

            HorizontalDivider(thickness = 0.5.dp, color = LightGrey)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TransactionItemPreview() {
    AppTheme {
        TransactionItem(
            title = "Transfer to Card",
            subTitle = "Sargis Khlopuzyan",
            amount = "120.00",
            currency = "AMD",
            status = TransactionStatus.CONFIRMED,
            iconRes = SharedRes.drawable.compose_multiplatform,
            isDarkTheme = false
        )
    }
}

@Preview(name = "TransactionsItem - Dark", showBackground = true)
@Composable
private fun TransactionItemDarkPreview() {
    AppTheme(darkTheme = true) {
        TransactionItem(
            title = "Transfer to Card",
            subTitle = "Sargis Khlopuzyan",
            amount = "120.00",
            currency = "AMD",
            status = TransactionStatus.CONFIRMED,
            iconRes = SharedRes.drawable.compose_multiplatform,
            isDarkTheme = true
        )
    }
}

