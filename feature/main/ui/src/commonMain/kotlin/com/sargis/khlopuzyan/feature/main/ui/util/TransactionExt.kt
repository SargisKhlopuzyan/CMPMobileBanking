package com.sargis.khlopuzyan.feature.main.ui.util

import androidx.compose.runtime.Composable
import com.sargis.khlopuzyan.core.ui.UiText
import com.sargis.khlopuzyan.designsystem.resources.SharedRes
import com.sargis.khlopuzyan.designsystem.resources.cancelled
import com.sargis.khlopuzyan.designsystem.resources.compose_multiplatform
import com.sargis.khlopuzyan.designsystem.resources.confirmed
import com.sargis.khlopuzyan.designsystem.resources.created
import com.sargis.khlopuzyan.designsystem.resources.currency_exchange
import com.sargis.khlopuzyan.designsystem.resources.editable
import com.sargis.khlopuzyan.designsystem.resources.ic_currency_exchange
import com.sargis.khlopuzyan.designsystem.resources.ic_transfer_to_card
import com.sargis.khlopuzyan.designsystem.resources.pending
import com.sargis.khlopuzyan.designsystem.resources.refused
import com.sargis.khlopuzyan.designsystem.resources.signed
import com.sargis.khlopuzyan.designsystem.resources.transfer_to_account
import com.sargis.khlopuzyan.designsystem.resources.transfer_to_card
import com.sargis.khlopuzyan.designsystem.resources.utility_group_payment
import com.sargis.khlopuzyan.designsystem.resources.utility_payment
import com.sargis.khlopuzyan.feature.main.domain.transactions.Currency
import com.sargis.khlopuzyan.feature.main.domain.transactions.CurrencyExchange
import com.sargis.khlopuzyan.feature.main.domain.transactions.PoliceAdministrativeFine
import com.sargis.khlopuzyan.feature.main.domain.transactions.Transaction
import com.sargis.khlopuzyan.feature.main.domain.transactions.TransactionStatus
import com.sargis.khlopuzyan.feature.main.domain.transactions.TransferToAccount
import com.sargis.khlopuzyan.feature.main.domain.transactions.TransferToCard
import com.sargis.khlopuzyan.feature.main.domain.transactions.UtilityGroupPayment
import com.sargis.khlopuzyan.feature.main.domain.transactions.UtilityPayment
import com.sargis.khlopuzyan.feature.main.ui.transactions.TransactionListItem
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

fun Transaction.getTransactionName(): StringResource {
    return when (this) {
        is CurrencyExchange -> SharedRes.string.currency_exchange
        is PoliceAdministrativeFine -> SharedRes.string.currency_exchange
        is TransferToAccount -> SharedRes.string.transfer_to_account
        is TransferToCard -> SharedRes.string.transfer_to_card
        is UtilityGroupPayment -> SharedRes.string.utility_group_payment
        is UtilityPayment -> SharedRes.string.utility_payment
    }
}

@Composable
fun Transaction.toTransactionListItem(): TransactionListItem {
    var amount: Double
    var currency: Currency
    var title: String
    var subtitle: String

    when (this) {
        is CurrencyExchange -> {
            title = this.aim
            subtitle = this.aim
            amount = this.toAmount
            currency = this.toCurrency
        }
        is PoliceAdministrativeFine -> {
            title = this.aim
            subtitle = this.beneficiaryName
            amount = this.amount
            currency = this.currency
        }
        is TransferToAccount -> {
            title = this.aim
            subtitle = this.beneficiaryName
            amount = this.amount
            currency = this.currency
        }
        is TransferToCard -> {
            title = this.aim
            subtitle = UiText.StringResourceId(this.getTransactionName()).asString()
            amount = this.amount
            currency = this.currency
        }
        is UtilityGroupPayment -> {
            title = this.aim
            subtitle = UiText.StringResourceId(this.getTransactionName()).asString()
            amount = this.utilityPayments.sumOf { it.paymentAmount }
            currency = this.utilityPayments.first().paymentAmountCurrency
        }
        is UtilityPayment -> {
            title = this.utility.name
            subtitle = UiText.StringResourceId(this.getTransactionName()).asString()
            amount = this.paymentAmount
            currency = this.paymentAmountCurrency
        }
    }
    return TransactionListItem(
        iconRes = getTransactionIcon(),
        transactionNumber = this.transactionNumber,
        date = this.date,
        title = title,
        subtitle = subtitle,
        amount = amount,
        currency = currency,
        transactionType = this.transactionType,
        transactionStatus = this.transactionStatus,
        transactionCategory = this.transactionCategory
    )
}

fun TransactionStatus.isConfirmed(): Boolean {
    return this == TransactionStatus.CONFIRMED
}

fun TransactionStatus.localizedRes(): StringResource {
    return when (this) {
        TransactionStatus.PENDING -> SharedRes.string.pending
        TransactionStatus.CONFIRMED -> SharedRes.string.confirmed
        TransactionStatus.REFUSED -> SharedRes.string.refused
        TransactionStatus.CANCELLED -> SharedRes.string.cancelled
        TransactionStatus.EDITABLE -> SharedRes.string.editable
        TransactionStatus.CREATED -> SharedRes.string.created
        TransactionStatus.SIGNED -> SharedRes.string.signed
    }
}

fun Transaction.getTransactionIcon(): DrawableResource {
    return when (this) {
        is CurrencyExchange -> SharedRes.drawable.ic_currency_exchange
        is PoliceAdministrativeFine -> SharedRes.drawable.compose_multiplatform
        is TransferToAccount -> SharedRes.drawable.compose_multiplatform
        is TransferToCard -> SharedRes.drawable.ic_transfer_to_card
        is UtilityGroupPayment -> SharedRes.drawable.ic_transfer_to_card
        is UtilityPayment -> SharedRes.drawable.ic_transfer_to_card
    }
}