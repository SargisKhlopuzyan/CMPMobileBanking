package com.sargis.khlopuzyan.core.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sargis.khlopuzyan.feature.applications.ui.amioPackageActivationApplication.AmioPackageActivationApplicationScreen
import com.sargis.khlopuzyan.feature.applications.ui.applications.ApplicationsScreen
import com.sargis.khlopuzyan.feature.applications.ui.cashWithdrawalApplication.CashWithdrawalApplicationScreen
import com.sargis.khlopuzyan.feature.applications.ui.onlineLoan.OnlineLoanScreen
import com.sargis.khlopuzyan.feature.applications.ui.openDigitalCard.OpenDigitalCardScreen
import com.sargis.khlopuzyan.feature.applications.ui.openNewAccount.OpenNewAccountScreen
import com.sargis.khlopuzyan.feature.applications.ui.openNewDeposit.OpenNewDepositScreen
import com.sargis.khlopuzyan.feature.applications.ui.orderNewPlasticCard.OrderNewPlasticCardScreen
import com.sargis.khlopuzyan.feature.applications.ui.orderReference.OrderReferenceScreen
import com.sargis.khlopuzyan.feature.applications.ui.receiveTransferOnAccountOrCard.ReceiveTransferOnAccountOrCardScreen
import kotlinx.serialization.Serializable

object ApplicationsNavGraph : BaseNavGraph {

    sealed interface Dest {
        @Serializable // This is for type safe navigation
        data object Root : Dest

        @Serializable // This is for type safe navigation
        data object Applications : Dest

        @Serializable // This is for type safe navigation
        data object OnlineLoan : Dest

        @Serializable
        data object AmioPackageActivationApplication : Dest

        @Serializable
        data object OpenNewAccount : Dest

        @Serializable
        data object OpenNewDeposit : Dest

        @Serializable
        data object OpenDigitalCard : Dest

        @Serializable
        data object CashWithdrawalApplication : Dest

        @Serializable
        data object ReceiveTransferOnAccountOrCard : Dest

        @Serializable
        data object OrderReference : Dest

        @Serializable
        data object OrderNewPlasticCard : Dest
    }

    override fun build(
        modifier: Modifier,
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation<Dest.Root>(startDestination = Dest.Applications::class) {
            composable<Dest.Applications> { navBackStackEntry ->
                ApplicationsScreen()
            }
            composable<Dest.OnlineLoan> { navBackStackEntry ->
                OnlineLoanScreen()
            }
            composable<Dest.AmioPackageActivationApplication> { navBackStackEntry ->
                AmioPackageActivationApplicationScreen()
            }
            composable<Dest.OpenNewAccount> { navBackStackEntry ->
                OpenNewAccountScreen()
            }
            composable<Dest.OpenNewDeposit> { navBackStackEntry ->
                OpenNewDepositScreen()
            }
            composable<Dest.OpenDigitalCard> { navBackStackEntry ->
                OpenDigitalCardScreen()
            }
            composable<Dest.CashWithdrawalApplication> { navBackStackEntry ->
                CashWithdrawalApplicationScreen()
            }
            composable<Dest.ReceiveTransferOnAccountOrCard> { navBackStackEntry ->
                ReceiveTransferOnAccountOrCardScreen()
            }
            composable<Dest.OrderReference> { navBackStackEntry ->
                OrderReferenceScreen()
            }
            composable<Dest.OrderNewPlasticCard> { navBackStackEntry ->
                OrderNewPlasticCardScreen()
            }
        }
    }
}