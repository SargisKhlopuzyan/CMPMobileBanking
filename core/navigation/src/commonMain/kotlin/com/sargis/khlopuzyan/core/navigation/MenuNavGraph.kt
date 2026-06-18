package com.sargis.khlopuzyan.core.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sargis.khlopuzyan.feature.menu.ui.about.AboutScreen
import com.sargis.khlopuzyan.feature.menu.ui.beneficiaries.BeneficiariesScreen
import com.sargis.khlopuzyan.feature.menu.ui.bonds.BondsScreen
import com.sargis.khlopuzyan.feature.menu.ui.calculator.CalculatorScreen
import com.sargis.khlopuzyan.feature.menu.ui.debts.DebtsScreen
import com.sargis.khlopuzyan.feature.menu.ui.incomeDeclarationReference.IncomeDeclarationReferenceScreen
import com.sargis.khlopuzyan.feature.menu.ui.map.MapScreen
import com.sargis.khlopuzyan.feature.menu.ui.menu.MenuScreen
import com.sargis.khlopuzyan.feature.menu.ui.messages.MessagesScreen
import com.sargis.khlopuzyan.feature.menu.ui.moneyInjunctions.MoneyInjunctionsScreen
import com.sargis.khlopuzyan.feature.menu.ui.news.NewsScreen
import com.sargis.khlopuzyan.feature.menu.ui.pensionAccount.PensionAccountScreen
import com.sargis.khlopuzyan.feature.menu.ui.rates.RatesScreen
import com.sargis.khlopuzyan.feature.menu.ui.vehicles.VehiclesScreen
import kotlinx.serialization.Serializable

object MenuNavGraph : BaseNavGraph {

    sealed interface Dest {
        @Serializable // This is for type safe navigation
        data object Root : Dest

        @Serializable
        data object Menu : Dest

        @Serializable
        data object Messages : Dest

        @Serializable
        data object Beneficiaries : Dest

        @Serializable
        data object Vehicles : Dest

        @Serializable
        data object Debts : Dest

        @Serializable
        data object PensionAccount : Dest

        @Serializable
        data object IncomeDeclarationReference : Dest

        @Serializable
        data object Bonds : Dest

        @Serializable
        data object MoneyInjunctions : Dest

        @Serializable
        data object Rates : Dest

        @Serializable
        data object Calculator : Dest

        @Serializable
        data object Map : Dest

        @Serializable
        data object News : Dest

        @Serializable
        data object About : Dest
    }

    override fun build(
        modifier: Modifier,
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation<Dest.Root>(startDestination = Dest.Menu::class) {
            composable<Dest.Menu> { navBackStackEntry ->
                MenuScreen()
            }
            composable<Dest.Messages> { navBackStackEntry ->
                MessagesScreen()
            }
            composable<Dest.Beneficiaries> { navBackStackEntry ->
                BeneficiariesScreen()
            }
            composable<Dest.Vehicles> { navBackStackEntry ->
                VehiclesScreen()
            }
            composable<Dest.Debts> { navBackStackEntry ->
                DebtsScreen()
            }
            composable<Dest.PensionAccount> { navBackStackEntry ->
                PensionAccountScreen()
            }
            composable<Dest.IncomeDeclarationReference> { navBackStackEntry ->
                IncomeDeclarationReferenceScreen()
            }
            composable<Dest.Bonds> { navBackStackEntry ->
                BondsScreen()
            }
            composable<Dest.MoneyInjunctions> { navBackStackEntry ->
                MoneyInjunctionsScreen()
            }
            composable<Dest.Rates> { navBackStackEntry ->
                RatesScreen()
            }
            composable<Dest.Calculator> { navBackStackEntry ->
                CalculatorScreen()
            }
            composable<Dest.Map> { navBackStackEntry ->
                MapScreen()
            }
            composable<Dest.News> { navBackStackEntry ->
                NewsScreen()
            }
            composable<Dest.About> { navBackStackEntry ->
                AboutScreen()
            }
        }
    }
}