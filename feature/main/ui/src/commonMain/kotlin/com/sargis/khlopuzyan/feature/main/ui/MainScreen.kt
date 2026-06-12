package com.sargis.khlopuzyan.feature.main.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sargis.khlopuzyan.designsystem.theme.AppTheme
import com.sargis.khlopuzyan.feature.main.domain.transactions.CurrencyExchange
import com.sargis.khlopuzyan.feature.main.domain.transactions.PoliceAdministrativeFine
import com.sargis.khlopuzyan.feature.main.domain.transactions.TransactionStatus
import com.sargis.khlopuzyan.feature.main.domain.transactions.TransferToAccount
import com.sargis.khlopuzyan.feature.main.domain.transactions.TransferToCard
import com.sargis.khlopuzyan.feature.main.ui.transactions.CategorizedTransactionsList

@Composable
fun MainScreen() {
    AppTheme {
        CategorizedTransactionsList(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            transactions = mockTransactions
        )
    }
}

private val mockTransactions = listOf(
    CurrencyExchange(
        status = TransactionStatus.CONFIRMED,
        fromAmount = 100.0,
        fromCurrency = "USD",
        toAmount = 97.5,
        toCurrency = "EUR",
        commission = "20000.50",
        commissionCurrency = "USD",
        transactionNumber = 1001,
        date = "11 Jun 2026",
        fromAccount = "1234 5678 9012 3456",
        toAccount = "DE89 3704 0044 0532 0130 00",
        rate = "0.975",
        aim = "Currency exchange"
    ),
    PoliceAdministrativeFine(
        status = TransactionStatus.PENDING,
        amount = 50.0,
        currency = "USD",
        commission = "1012.00",
        transactionNumber = 1002,
        date = "12 Jun 2026",
        decreeNumber = 458712,
        fullName = "John Doe",
        beneficiaryAccount = "AM17 2050 0000 1234 5678 9012",
        beneficiaryName = "Road Police Department",
        fromAccount = "1234 5678 9012 3456",
        debt = "0.00",
        aim = "Administrative fine"
    ),
    TransferToAccount(
        status = TransactionStatus.CONFIRMED,
        amount = 250.0,
        currency = "USD",
        commission = "0.50",
        transactionNumber = 1003,
        date = "11 Jun 2026",
        account = "1234 5678 9012 3456",
        beneficiaryAccount = "9876 5432 1098 7654",
        beneficiaryBank = "Acme Bank",
        beneficiaryName = "Jane Smith",
        aim = "Family transfer"
    ),
    TransferToCard(
        status = TransactionStatus.REFUSED,
        amount = 750052545.0,
        currency = "USD",
        transactionNumber = 1004,
        date = "14 Jun 2026",
        country = "USA",
        account = "1234 5678 9012 3456",
        toCard = "**** **** **** 4321",
        aim = "Gift transfer"
    ),
    CurrencyExchange(
        status = TransactionStatus.CONFIRMED,
        fromAmount = 100.0,
        fromCurrency = "USD",
        toAmount = 970568.5,
        toCurrency = "EUR",
        commission = "2.50",
        commissionCurrency = "USD",
        transactionNumber = 1001,
        date = "14 Jun 2026",
        fromAccount = "1234 5678 9012 3456",
        toAccount = "DE89 3704 0044 0532 0130 00",
        rate = "0.975",
        aim = "Currency exchange"
    ),
    PoliceAdministrativeFine(
        status = TransactionStatus.PENDING,
        amount = 50.0,
        currency = "USD",
        commission = "1.00",
        transactionNumber = 1002,
        date = "12 Jun 2026",
        decreeNumber = 458712,
        fullName = "John Doe",
        beneficiaryAccount = "AM17 2050 0000 1234 5678 9012",
        beneficiaryName = "Road Police Department",
        fromAccount = "1234 5678 9012 3456",
        debt = "0.00",
        aim = "Administrative fine"
    ),
    TransferToAccount(
        status = TransactionStatus.CONFIRMED,
        amount = 100805425780.0,
        currency = "AMD",
        commission = "5780.50",
        transactionNumber = 1003,
        date = "11 Jun 2026",
        account = "1234 5678 9012 3456",
        beneficiaryAccount = "9876 5432 1098 7654",
        beneficiaryBank = "Acme Bank",
        beneficiaryName = "SARGIS KHLOPUZYAN HRACHIKI",
        aim = "Family transfer"
    ),
    TransferToCard(
        status = TransactionStatus.REFUSED,
        amount = 75.0,
        currency = "USD",
        transactionNumber = 1004,
        date = "14 Jun 2026",
        country = "USA",
        account = "1234 5678 9012 3456",
        toCard = "**** **** **** 4321",
        aim = "Gift transfer"
    ),
    CurrencyExchange(
        status = TransactionStatus.CONFIRMED,
        fromAmount = 100.0,
        fromCurrency = "USD",
        toAmount = 97.5,
        toCurrency = "EUR",
        commission = "2.50",
        commissionCurrency = "USD",
        transactionNumber = 1001,
        date = "11 Jun 2026",
        fromAccount = "1234 5678 9012 3456",
        toAccount = "DE89 3704 0044 0532 0130 00",
        rate = "0.975",
        aim = "Currency exchange"
    ),
    PoliceAdministrativeFine(
        status = TransactionStatus.PENDING,
        amount = 50.0,
        currency = "USD",
        commission = "1.00",
        transactionNumber = 1002,
        date = "12 Jun 2026",
        decreeNumber = 458712,
        fullName = "John Doe",
        beneficiaryAccount = "AM17 2050 0000 1234 5678 9012",
        beneficiaryName = "Road Police Department",
        fromAccount = "1234 5678 9012 3456",
        debt = "0.00",
        aim = "Administrative fine"
    ),
    TransferToAccount(
        status = TransactionStatus.CONFIRMED,
        amount = 250.0,
        currency = "USD",
        commission = "0.50",
        transactionNumber = 1003,
        date = "14 Jun 2026",
        account = "1234 5678 9012 3456",
        beneficiaryAccount = "9876 5432 1098 7654",
        beneficiaryBank = "Acme Bank",
        beneficiaryName = "Jane Smith",
        aim = "Family transfer"
    ),
    TransferToCard(
        status = TransactionStatus.REFUSED,
        amount = 75.0,
        currency = "USD",
        transactionNumber = 1004,
        date = "14 Jun 2026",
        country = "USA",
        account = "1234 5678 9012 3456",
        toCard = "**** **** **** 4321",
        aim = "Gift transfer"
    ),
    CurrencyExchange(
        status = TransactionStatus.CONFIRMED,
        fromAmount = 100.0,
        fromCurrency = "USD",
        toAmount = 97.5,
        toCurrency = "EUR",
        commission = "2.50",
        commissionCurrency = "USD",
        transactionNumber = 1001,
        date = "15 Jun 2026",
        fromAccount = "1234 5678 9012 3456",
        toAccount = "DE89 3704 0044 0532 0130 00",
        rate = "0.975",
        aim = "Currency exchange"
    ),
    PoliceAdministrativeFine(
        status = TransactionStatus.PENDING,
        amount = 50.0,
        currency = "USD",
        commission = "1.00",
        transactionNumber = 1002,
        date = "14 Jun 2026",
        decreeNumber = 458712,
        fullName = "John Doe",
        beneficiaryAccount = "AM17 2050 0000 1234 5678 9012",
        beneficiaryName = "Road Police Department",
        fromAccount = "1234 5678 9012 3456",
        debt = "0.00",
        aim = "Administrative fine"
    ),
    TransferToAccount(
        status = TransactionStatus.CONFIRMED,
        amount = 250.0,
        currency = "USD",
        commission = "0.50",
        transactionNumber = 1003,
        date = "17 Jun 2026",
        account = "1234 5678 9012 3456",
        beneficiaryAccount = "9876 5432 1098 7654",
        beneficiaryBank = "Acme Bank",
        beneficiaryName = "Jane Smith",
        aim = "Family transfer"
    ),
    TransferToCard(
        status = TransactionStatus.REFUSED,
        amount = 75.0,
        currency = "USD",
        transactionNumber = 1004,
        date = "18 Jun 2026",
        country = "USA",
        account = "1234 5678 9012 3456",
        toCard = "**** **** **** 4321",
        aim = "Gift transfer"
    ),
    TransferToAccount(
        status = TransactionStatus.CONFIRMED,
        amount = 250.0,
        currency = "USD",
        commission = "0.50",
        transactionNumber = 1003,
        date = "11 Jun 2026",
        account = "1234 5678 9012 3456",
        beneficiaryAccount = "9876 5432 1098 7654",
        beneficiaryBank = "Acme Bank",
        beneficiaryName = "Jane Smith",
        aim = "Family transfer"
    ),
    TransferToCard(
        status = TransactionStatus.REFUSED,
        amount = 75.0,
        currency = "USD",
        transactionNumber = 1004,
        date = "19 Jun 2026",
        country = "USA",
        account = "1234 5678 9012 3456",
        toCard = "**** **** **** 4321",
        aim = "Gift transfer"
    ),
    CurrencyExchange(
        status = TransactionStatus.CONFIRMED,
        fromAmount = 100.0,
        fromCurrency = "USD",
        toAmount = 97.5,
        toCurrency = "EUR",
        commission = "2.50",
        commissionCurrency = "USD",
        transactionNumber = 1001,
        date = "21 Jun 2026",
        fromAccount = "1234 5678 9012 3456",
        toAccount = "DE89 3704 0044 0532 0130 00",
        rate = "0.975",
        aim = "Currency exchange"
    ), TransferToAccount(
        status = TransactionStatus.CONFIRMED,
        amount = 250.0,
        currency = "USD",
        commission = "0.50",
        transactionNumber = 1003,
        date = "20 Jun 2026",
        account = "1234 5678 9012 3456",
        beneficiaryAccount = "9876 5432 1098 7654",
        beneficiaryBank = "Acme Bank",
        beneficiaryName = "Jane Smith",
        aim = "Family transfer"
    ),
    TransferToCard(
        status = TransactionStatus.REFUSED,
        amount = 75.0,
        currency = "USD",
        transactionNumber = 1004,
        date = "19 Jun 2026",
        country = "USA",
        account = "1234 5678 9012 3456",
        toCard = "**** **** **** 4321",
        aim = "Gift transfer"
    ),
    CurrencyExchange(
        status = TransactionStatus.CONFIRMED,
        fromAmount = 100.0,
        fromCurrency = "USD",
        toAmount = 97.5,
        toCurrency = "EUR",
        commission = "2.50",
        commissionCurrency = "USD",
        transactionNumber = 1001,
        date = "12 Jun 2026",
        fromAccount = "1234 5678 9012 3456",
        toAccount = "DE89 3704 0044 0532 0130 00",
        rate = "0.975",
        aim = "Currency exchange"
    )
)