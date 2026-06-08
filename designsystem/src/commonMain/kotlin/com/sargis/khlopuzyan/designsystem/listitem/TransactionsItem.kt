package com.sargis.khlopuzyan.designsystem.listitem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TransactionsItem(
    modifier: Modifier = Modifier,
    iconRes: Int? = null,
    aim: String? = null,
    beneficiaryName: String? = null,
    amount: String? = null,
    status: String? = null
) {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Transaction title")
            Text(text = "Transaction subtitle")
        }

        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(text = "$120.00")
            Text(text = "Today")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TransactionsItemPreview() {
    MaterialTheme {
        TransactionsItem()
    }
}
