package com.sargis.khlopuzyan.core.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sargis.khlopuzyan.feature.authentication.ui.about.AboutScreen
import com.sargis.khlopuzyan.feature.authentication.ui.becomeACustomer.BecomeACustomerScreen
import com.sargis.khlopuzyan.feature.authentication.ui.calculator.CalculatorScreen
import com.sargis.khlopuzyan.feature.authentication.ui.login.LoginScreen
import com.sargis.khlopuzyan.feature.authentication.ui.loginMain.LoginMainScreen
import com.sargis.khlopuzyan.feature.authentication.ui.map.MapScreen
import com.sargis.khlopuzyan.feature.authentication.ui.news.NewsScreen
import com.sargis.khlopuzyan.feature.authentication.ui.onlineRegistration.OnlineRegistrationScreen
import com.sargis.khlopuzyan.feature.authentication.ui.rates.RatesScreen
import com.sargis.khlopuzyan.feature.authentication.ui.resetPassword.ResetPasswordScreen
import kotlinx.serialization.Serializable

object AuthenticationNavGraph : BaseNavGraph {

    sealed interface Dest {
        @Serializable // This is for type safe navigation
        data object Root : Dest

        @Serializable
        data object LoginMain : Dest

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

        @Serializable
        data object Login : Dest

        @Serializable
        data object ResetPassword : Dest

        @Serializable
        data object OnlineRegistration : Dest

        @Serializable
        data object BecomeACustomer : Dest
    }

    override fun build(
        modifier: Modifier,
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation<Dest.Root>(startDestination = Dest.LoginMain::class) {
            composable<Dest.LoginMain> { navBackStackEntry ->
                LoginMainScreen()
            }
            composable<Dest.Login> { navBackStackEntry ->
                LoginScreen()
            }
            composable<Dest.ResetPassword> { navBackStackEntry ->
                ResetPasswordScreen()
            }
            composable<Dest.OnlineRegistration> { navBackStackEntry ->
                OnlineRegistrationScreen()
            }
            composable<Dest.BecomeACustomer> { navBackStackEntry ->
                BecomeACustomerScreen()
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