package com.sargis.khlopuzyan.cmpmobilebanking

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.sargis.khlopuzyan.core.navigation.AuthenticationNavGraph
import com.sargis.khlopuzyan.core.navigation.BaseNavGraph
import com.sargis.khlopuzyan.core.navigation.MainNavGraph
import com.sargis.khlopuzyan.designsystem.theme.AppTheme

@Composable
@Preview
fun App() {
    AppTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
//            startDestination = AuthenticationNavGraph.Dest.Root
            startDestination = MainNavGraph.Dest.Root
        ) {
            listOf<BaseNavGraph>(
                AuthenticationNavGraph,
                MainNavGraph,
            ).forEach { baseNavGraph ->
                baseNavGraph.build(
                    modifier = Modifier.fillMaxSize(),
                    navController = navController,
                    navGraphBuilder = this
                )
            }
        }
    }
}