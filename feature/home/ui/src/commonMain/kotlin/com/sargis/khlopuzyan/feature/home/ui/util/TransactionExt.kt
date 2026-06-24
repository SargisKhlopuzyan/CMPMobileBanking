package com.sargis.khlopuzyan.feature.home.ui.util

import com.sargis.khlopuzyan.core.designsystem.resources.SharedRes
import com.sargis.khlopuzyan.core.designsystem.resources.cancelled
import com.sargis.khlopuzyan.core.designsystem.resources.compose_multiplatform
import com.sargis.khlopuzyan.core.designsystem.resources.confirmed
import com.sargis.khlopuzyan.core.designsystem.resources.created
import com.sargis.khlopuzyan.core.designsystem.resources.currency_exchange
import com.sargis.khlopuzyan.core.designsystem.resources.editable
import com.sargis.khlopuzyan.core.designsystem.resources.ic_currency_exchange
import com.sargis.khlopuzyan.core.designsystem.resources.ic_transfer_to_card
import com.sargis.khlopuzyan.core.designsystem.resources.pending
import com.sargis.khlopuzyan.core.designsystem.resources.refused
import com.sargis.khlopuzyan.core.designsystem.resources.signed
import com.sargis.khlopuzyan.core.designsystem.resources.transfer_to_account
import com.sargis.khlopuzyan.core.designsystem.resources.transfer_to_card
import com.sargis.khlopuzyan.core.designsystem.resources.utility_group_payment
import com.sargis.khlopuzyan.core.designsystem.resources.utility_payment
import com.sargis.khlopuzyan.feature.home.domain.model.transactions.Currency
import com.sargis.khlopuzyan.feature.home.domain.model.transactions.CurrencyExchange
import com.sargis.khlopuzyan.feature.home.domain.model.transactions.PoliceAdministrativeFine
import com.sargis.khlopuzyan.feature.home.domain.model.transactions.Transaction
import com.sargis.khlopuzyan.feature.home.domain.model.transactions.TransactionStatus
import com.sargis.khlopuzyan.feature.home.domain.model.transactions.TransferToAccount
import com.sargis.khlopuzyan.feature.home.domain.model.transactions.TransferToCard
import com.sargis.khlopuzyan.feature.home.domain.model.transactions.UtilityGroupPayment
import com.sargis.khlopuzyan.feature.home.domain.model.transactions.UtilityPayment
import com.sargis.khlopuzyan.feature.home.ui.transactions.TransactionListItem
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.getString

//suspend fun Transaction.getTransactionName(): UiText {
//    return when (this) {
//        is PoliceAdministrativeFine -> UiText.StringResourceId(SharedRes.string.currency_exchange)
//        is TransferToAccount -> UiText.StringResourceId(SharedRes.string.transfer_to_account)
//        is TransferToCard -> UiText.StringResourceId(SharedRes.string.transfer_to_card)
//        is UtilityGroupPayment -> UiText.StringResourceId(SharedRes.string.utility_group_payment)
//        is UtilityPayment -> UiText.StringResourceId(SharedRes.string.utility_payment)
//    }
//}

suspend fun Transaction.getTransactionName(): String {
    return when (this) {
        is CurrencyExchange -> getString(SharedRes.string.currency_exchange)
        is PoliceAdministrativeFine -> getString(SharedRes.string.currency_exchange)
        is TransferToAccount -> getString(SharedRes.string.transfer_to_account)
        is TransferToCard -> getString(SharedRes.string.transfer_to_card)
        is UtilityGroupPayment -> getString(SharedRes.string.utility_group_payment)
        is UtilityPayment -> getString(SharedRes.string.utility_payment)
    }
}

suspend fun Transaction.toTransactionListItem(): TransactionListItem {
    var amount: Double
    var currency: Currency
    var title: String
    var subtitle: String

    when (this) {
        is CurrencyExchange -> {
            title = this.aim
//            subtitle = UiText.DynamicString(this.aim)
            subtitle = this.aim
            amount = this.toAmount
            currency = this.toCurrency
        }
        is PoliceAdministrativeFine -> {
            title = this.aim
//            subtitle = UiText.DynamicString(this.beneficiaryName)
            subtitle = this.beneficiaryName
            amount = this.amount
            currency = this.currency
        }
        is TransferToAccount -> {
            title = this.aim
//            subtitle = UiText.DynamicString(this.beneficiaryName)
            subtitle = this.beneficiaryName
            amount = this.amount
            currency = this.currency
        }
        is TransferToCard -> {
            title = this.aim
            subtitle = this.getTransactionName()
            amount = this.amount
            currency = this.currency
        }
        is UtilityGroupPayment -> {
            title = this.aim
            subtitle = this.getTransactionName()
            amount = this.utilityPayments.sumOf { it.paymentAmount }
            currency = this.utilityPayments.first().paymentAmountCurrency
        }
        is UtilityPayment -> {
            title = this.utility.name
            subtitle = this.getTransactionName()
            amount = this.paymentAmount
            currency = this.paymentAmountCurrency
        }
    }
    return TransactionListItem(
        iconRes = getTransactionIcon(),
        transactionNumber = this.transactionNumber,
        date = this.date,
        title = title,
//        subtitle = subtitle.asString(),
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

suspend fun List<Transaction>.toTransactionListItems() = this.map { transaction ->
    transaction.toTransactionListItem()
}