package com.sargis.khlopuzyan.core.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sargis.khlopuzyan.feature.main.ui.account.AccountScreen
import com.sargis.khlopuzyan.feature.main.ui.accounts.AccountsScreen
import com.sargis.khlopuzyan.feature.main.ui.attachAnotherCard.AttachAnotherCardScreen
import com.sargis.khlopuzyan.feature.main.ui.card.CardScreen
import com.sargis.khlopuzyan.feature.main.ui.deposit.DepositScreen
import com.sargis.khlopuzyan.feature.main.ui.deposits.DepositsScreen
import com.sargis.khlopuzyan.feature.main.ui.loans.LoansScreen
import com.sargis.khlopuzyan.feature.main.ui.newCard.NewCardScreen
import com.sargis.khlopuzyan.feature.main.ui.notification.NotificationScreen
import com.sargis.khlopuzyan.feature.main.ui.notifications.NotificationsScreen
import com.sargis.khlopuzyan.feature.main.ui.onlineLoan.OnlineLoanScreen
import com.sargis.khlopuzyan.feature.main.ui.openDigitalCard.OpenDigitalCardScreen
import com.sargis.khlopuzyan.feature.main.ui.openNewAccount.OpenNewAccountScreen
import com.sargis.khlopuzyan.feature.main.ui.openNewDeposit.OpenNewDepositScreen
import com.sargis.khlopuzyan.feature.main.ui.orderNewPlasticCard.OrderNewPlasticCardScreen
import com.sargis.khlopuzyan.feature.main.ui.setCardNewPIN.SetCardNewPINScreen
import com.sargis.khlopuzyan.feature.main.ui.transaction.TransactionScreen
import com.sargis.khlopuzyan.feature.main.ui.transactions.TransactionsScreen
import com.sargis.khlopuzyan.feature.main.ui.userProfile.UserProfileScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.car.CarScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.currencyExchange.CurrencyExchangeScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.depositReplenishment.DepositReplenishmentScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.internationalTransfer.InternationalTransferScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.internetAndTV.InternetAndTVScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.loanRepayment.LoanRepaymentScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.otherPayments.OtherPaymentsScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.payment.PaymentScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.paymentSearch.PaymentSearchScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.publicServices.PublicServicesScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.templatesAndGroups.TemplatesAndGroupsScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.transferArcaPay.TransferArcaPayScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.transferInRUB.TransferInRUBScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.transferToAccount.TransferToAccountScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.transferToBudget.TransferToBudgetScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.transferToCard.TransferToCardScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.transferToContact.TransferToContactScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.transfersAndPayments.TransfersAndPaymentsScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.tuitionFee.TuitionFeeScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.utility.UtilityScreen
import com.sargis.khlopuzyan.feature.transfersandpayments.ui.utilityGroupPayment.UtilityGroupPaymentScreen
import kotlinx.serialization.Serializable

object TransfersAndPaymentsNavGraph : BaseNavGraph {

    sealed interface Dest {
        @Serializable // This is for type safe navigation
        data object Root : Dest

        @Serializable // This is for type safe navigation
        data object TransfersAndPayments : Dest

        @Serializable
        data object TemplatesAndGroups : Dest

        @Serializable
        data object TransferToAccount : Dest

        @Serializable
        data object TransferToCard : Dest

        @Serializable
        data object TransferToContact : Dest

        @Serializable
        data object TransferArcaPay : Dest

        @Serializable
        data object TransferToBudget : Dest

        @Serializable
        data object InternationalTransfer : Dest

        @Serializable
        data object TransferInRUB : Dest

        @Serializable
        data object CurrencyExchange : Dest

        @Serializable
        data object DepositReplenishment : Dest

        @Serializable
        data object Utility : Dest

        @Serializable
        data object InternetAndTV : Dest

        @Serializable
        data object Car : Dest

        @Serializable
        data object PublicServices : Dest

        @Serializable
        data object OtherPayments : Dest

        @Serializable
        data object LoanRepayment : Dest

        @Serializable
        data object TuitionFee : Dest

        @Serializable
        data object PaymentSearch : Dest

        @Serializable
        data object Payment : Dest

        @Serializable
        data object UtilityGroupPayment : Dest
    }

    override fun build(
        modifier: Modifier,
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation<Dest.Root>(startDestination = Dest.TransfersAndPayments::class) {
            composable<Dest.TransfersAndPayments> { navBackStackEntry ->
                TransfersAndPaymentsScreen()
            }
            composable<Dest.TemplatesAndGroups> { navBackStackEntry ->
                TemplatesAndGroupsScreen()
            }
            composable<Dest.TransferToAccount> { navBackStackEntry ->
                TransferToAccountScreen()
            }
            composable<Dest.TransferToCard> { navBackStackEntry ->
                TransferToCardScreen()
            }
            composable<Dest.TransferToContact> { navBackStackEntry ->
                TransferToContactScreen()
            }
            composable<Dest.TransferArcaPay> { navBackStackEntry ->
                TransferArcaPayScreen()
            }
            composable<Dest.TransferToBudget> { navBackStackEntry ->
                TransferToBudgetScreen()
            }
            composable<Dest.InternationalTransfer> { navBackStackEntry ->
                InternationalTransferScreen()
            }
            composable<Dest.TransferInRUB> { navBackStackEntry ->
                TransferInRUBScreen()
            }
            composable<Dest.CurrencyExchange> { navBackStackEntry ->
                CurrencyExchangeScreen()
            }
            composable<Dest.DepositReplenishment> { navBackStackEntry ->
                DepositReplenishmentScreen()
            }
            composable<Dest.Utility> { navBackStackEntry ->
                UtilityScreen()
            }
            composable<Dest.InternetAndTV> { navBackStackEntry ->
                InternetAndTVScreen()
            }
            composable<Dest.Car> { navBackStackEntry ->
                CarScreen()
            }
            composable<Dest.PublicServices> { navBackStackEntry ->
                PublicServicesScreen()
            }
            composable<Dest.OtherPayments> { navBackStackEntry ->
                OtherPaymentsScreen()
            }
            composable<Dest.LoanRepayment> { navBackStackEntry ->
                LoanRepaymentScreen()
            }
            composable<Dest.TuitionFee> { navBackStackEntry ->
                TuitionFeeScreen()
            }
            composable<Dest.PaymentSearch> { navBackStackEntry ->
                PaymentSearchScreen()
            }
            composable<Dest.Payment> { navBackStackEntry ->
                PaymentScreen()
            }
            composable<Dest.UtilityGroupPayment> { navBackStackEntry ->
                UtilityGroupPaymentScreen()
            }
        }
    }
}