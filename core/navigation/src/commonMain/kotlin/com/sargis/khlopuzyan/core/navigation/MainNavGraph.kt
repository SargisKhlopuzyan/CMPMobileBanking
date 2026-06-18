package com.sargis.khlopuzyan.core.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sargis.khlopuzyan.feature.main.ui.MainScreen
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
import com.sargis.khlopuzyan.feature.main.ui.setCardNewPIN.SetCardNewPINScreen
import com.sargis.khlopuzyan.feature.main.ui.transaction.TransactionScreen
import com.sargis.khlopuzyan.feature.main.ui.transactions.TransactionsScreen
import kotlinx.serialization.Serializable

object MainNavGraph : BaseNavGraph {

    sealed interface Dest {
        @Serializable // This is for type safe navigation
        data object Root : Dest

        @Serializable
        data object Main : Dest

//        @Serializable
//        data object UserProfile : Dest

        @Serializable
        data object Notifications : Dest

        @Serializable
        data class Notification(val notificationId: Int) : Dest

        @Serializable
        data object NewCard : Dest

        //        @Serializable
        //        data object OpenDigitalCard : Dest

        //        @Serializable
        //        data object OrderNewPlasticCard : Dest

        @Serializable
        data object AttachAnotherCard : Dest

        @Serializable
        data object Card : Dest

        @Serializable
        data object SetCardNewPIN : Dest

        @Serializable
        data object Accounts : Dest

        //        @Serializable
        //        data object OpenNewAccount : Dest

        @Serializable
        data object Account : Dest

        @Serializable
        data object Loans : Dest

        //        @Serializable
        //        data object OnlineLoan : Dest

        @Serializable
        data object Deposits : Dest

        @Serializable
        data object Deposit : Dest

        //        @Serializable
        //        data object OpenNewDeposit : Dest

        @Serializable
        data object Transactions : Dest

        @Serializable
        data class Transaction(val transactionNumber: Int) : Dest
    }

    override fun build(
        modifier: Modifier,
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation<Dest.Root>(startDestination = Dest.Main::class) {
            //        navGraphBuilder.navigation<Dest.Root>(startDestination = Dest.Transactions::class) {
            composable<Dest.Main> { navBackStackEntry ->
                MainScreen()
            }
//            composable<Dest.UserProfile> { navBackStackEntry ->
//                UserProfileScreen()
//            }
            composable<Dest.Notifications> { navBackStackEntry ->
                NotificationsScreen()
            }
            composable<Dest.Notification> { navBackStackEntry ->
                NotificationScreen()
            }
            composable<Dest.NewCard> { navBackStackEntry ->
                NewCardScreen()
            }
            //            composable<Dest.OpenDigitalCard> { navBackStackEntry ->
            //                OpenDigitalCardScreen()
            //            }
            //            composable<Dest.OrderNewPlasticCard> { navBackStackEntry ->
            //                OrderNewPlasticCardScreen()
            //            }
            composable<Dest.AttachAnotherCard> { navBackStackEntry ->
                AttachAnotherCardScreen()
            }
            composable<Dest.Card> { navBackStackEntry ->
                CardScreen()
            }
            composable<Dest.SetCardNewPIN> { navBackStackEntry ->
                SetCardNewPINScreen()
            }
            composable<Dest.Accounts> { navBackStackEntry ->
                AccountsScreen()
            }
            //            composable<Dest.OpenNewAccount> { navBackStackEntry ->
            //                OpenNewAccountScreen()
            //            }
            composable<Dest.Account> { navBackStackEntry ->
                AccountScreen()
            }
            composable<Dest.Loans> { navBackStackEntry ->
                LoansScreen()
            }
            //            composable<Dest.OnlineLoan> { navBackStackEntry ->
            //                OnlineLoanScreen()
            //            }
            composable<Dest.Deposits> { navBackStackEntry ->
                DepositsScreen()
            }
            composable<Dest.Deposit> { navBackStackEntry ->
                DepositScreen()
            }
            //            composable<Dest.OpenNewDeposit> { navBackStackEntry ->
            //                OpenNewDepositScreen()
            //            }
            composable<Dest.Transactions> { navBackStackEntry ->
                TransactionsScreen()
            }
            composable<Dest.Transaction> { navBackStackEntry ->
                TransactionScreen()
            }
        }
    }
}