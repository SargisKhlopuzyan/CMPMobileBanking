package com.sargis.khlopuzyan.core.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sargis.khlopuzyan.feature.settings.ui.actions.ActionsScreen
import com.sargis.khlopuzyan.feature.settings.ui.changePassword.ChangePasswordScreen
import com.sargis.khlopuzyan.feature.settings.ui.defaultAccount.DefaultAccountScreen
import com.sargis.khlopuzyan.feature.settings.ui.devices.DevicesScreen
import com.sargis.khlopuzyan.feature.settings.ui.homePageAppearance.HomePageAppearanceScreen
import com.sargis.khlopuzyan.feature.settings.ui.security.SecurityScreen
import com.sargis.khlopuzyan.feature.settings.ui.settings.SettingsScreen
import com.sargis.khlopuzyan.feature.settings.ui.settingsForReceivingArcaPayTransfers.SettingsForReceivingArcaPayTransfersScreen
import com.sargis.khlopuzyan.feature.settings.ui.settingsForReceivingTransferViaPhoneNumber.SettingsForReceivingTransferViaPhoneNumberScreen
import com.sargis.khlopuzyan.feature.settings.ui.sortAccounts.SortAccountsScreen
import com.sargis.khlopuzyan.feature.settings.ui.sortCards.SortCardsScreen
import com.sargis.khlopuzyan.feature.settings.ui.sortTemplatesAndGroups.SortTemplatesAndGroupsScreen
import com.sargis.khlopuzyan.feature.settings.ui.sorting.SortingScreen
import com.sargis.khlopuzyan.feature.settings.ui.userProfile.UserProfileScreen
import com.sargis.khlopuzyan.feature.settings.ui.verification.VerificationScreen
import kotlinx.serialization.Serializable

object SettingsNavGraph : BaseNavGraph {

    sealed interface Dest {
        @Serializable // This is for type safe navigation
        data object Root : Dest

        @Serializable // This is for type safe navigation
        data object Settings : Dest

        @Serializable
        data object UserProfile : Dest

        @Serializable
        data object Security : Dest

        @Serializable
        data object Verification : Dest

        @Serializable
        data object ChangePassword : Dest

        @Serializable
        data object Devices : Dest

        @Serializable
        data object Actions : Dest

        @Serializable
        data object Sorting : Dest

        @Serializable
        data object SortAccounts : Dest

        @Serializable
        data object SortCards : Dest

        @Serializable
        data object SortTemplatesAndGroups : Dest

        @Serializable
        data object HomePageAppearance : Dest

        @Serializable
        data object DefaultAccount : Dest

        @Serializable
        data object SettingsForReceivingTransferViaPhoneNumber : Dest

        @Serializable
        data object SettingsForReceivingArcaPayTransfers : Dest
    }

    override fun build(
        modifier: Modifier,
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation<Dest.Root>(startDestination = Dest.Settings::class) {
            composable<Dest.Settings> { navBackStackEntry ->
                SettingsScreen()
            }
            composable<Dest.UserProfile> { navBackStackEntry ->
                UserProfileScreen()
            }
            composable<Dest.Security> { navBackStackEntry ->
                SecurityScreen()
            }
            composable<Dest.Verification> { navBackStackEntry ->
                VerificationScreen()
            }
            composable<Dest.ChangePassword> { navBackStackEntry ->
                ChangePasswordScreen()
            }
            composable<Dest.Devices> { navBackStackEntry ->
                DevicesScreen()
            }
            composable<Dest.Actions> { navBackStackEntry ->
                ActionsScreen()
            }
            composable<Dest.Sorting> { navBackStackEntry ->
                SortingScreen()
            }
            composable<Dest.SortAccounts> { navBackStackEntry ->
                SortAccountsScreen()
            }
            composable<Dest.SortCards> { navBackStackEntry ->
                SortCardsScreen()
            }
            composable<Dest.SortTemplatesAndGroups> { navBackStackEntry ->
                SortTemplatesAndGroupsScreen()
            }
            composable<Dest.HomePageAppearance> { navBackStackEntry ->
                HomePageAppearanceScreen()
            }
            composable<Dest.DefaultAccount> { navBackStackEntry ->
                DefaultAccountScreen()
            }
            composable<Dest.SettingsForReceivingTransferViaPhoneNumber> { navBackStackEntry ->
                SettingsForReceivingTransferViaPhoneNumberScreen()
            }
            composable<Dest.SettingsForReceivingArcaPayTransfers> { navBackStackEntry ->
                SettingsForReceivingArcaPayTransfersScreen()
            }
        }
    }
}