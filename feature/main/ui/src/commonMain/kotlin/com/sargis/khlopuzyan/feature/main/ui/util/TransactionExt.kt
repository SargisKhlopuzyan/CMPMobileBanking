package com.sargis.khlopuzyan.feature.main.ui.util

import com.sargis.khlopuzyan.designsystem.resources.SharedRes
import com.sargis.khlopuzyan.designsystem.resources.compose_multiplatform
import com.sargis.khlopuzyan.designsystem.resources.confirmed
import com.sargis.khlopuzyan.designsystem.resources.currency_exchange
import com.sargis.khlopuzyan.designsystem.resources.pending
import com.sargis.khlopuzyan.designsystem.resources.refused
import com.sargis.khlopuzyan.designsystem.resources.transfer_to_account
import com.sargis.khlopuzyan.designsystem.resources.transfer_to_card
import com.sargis.khlopuzyan.feature.main.domain.transactions.CurrencyExchange
import com.sargis.khlopuzyan.feature.main.domain.transactions.PoliceAdministrativeFine
import com.sargis.khlopuzyan.feature.main.domain.transactions.Transaction
import com.sargis.khlopuzyan.feature.main.domain.transactions.TransactionStatus
import com.sargis.khlopuzyan.feature.main.domain.transactions.TransferToAccount
import com.sargis.khlopuzyan.feature.main.domain.transactions.TransferToCard
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

fun Transaction.getTransactionName(): StringResource {
    return when (this) {
        is CurrencyExchange -> SharedRes.string.currency_exchange
        is PoliceAdministrativeFine -> SharedRes.string.currency_exchange
        is TransferToAccount -> SharedRes.string.transfer_to_account
        is TransferToCard -> SharedRes.string.transfer_to_card
    }
}

fun TransactionStatus.isConfirmed(): Boolean {
    return this == TransactionStatus.CONFIRMED
}

fun TransactionStatus.localizedRes(): StringResource {
    return when (this) {
        TransactionStatus.PENDING -> SharedRes.string.pending
        TransactionStatus.CONFIRMED -> SharedRes.string.confirmed
        TransactionStatus.REFUSED -> SharedRes.string.refused
    }
}

fun Transaction.getTransactionIcon(): DrawableResource {
    return when (this) {
        is CurrencyExchange -> SharedRes.drawable.compose_multiplatform
        is PoliceAdministrativeFine -> SharedRes.drawable.compose_multiplatform
        is TransferToAccount -> SharedRes.drawable.compose_multiplatform
        is TransferToCard -> SharedRes.drawable.compose_multiplatform
    }
}