package com.jintu.qr_bnb.presentation.navigation

import com.jintu.qr_bnb.presentation.screen.MainScreen



import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jintu.qr_bnb.presentation.screen.MenuScreen
import com.jintu.qr_bnb.presentation.viewmodel.MainViewModel


@Composable
fun PlaceholderScreen(name: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("$name Screen", style = MaterialTheme.typography.headlineLarge)
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val mainViewModel: MainViewModel = viewModel()

    Scaffold(

        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = NavRoutes.HOME,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(NavRoutes.HOME) {
                MainScreen(viewModel = mainViewModel)
            }


            composable(NavRoutes.EXPLORE) {

                MenuScreen()
            }


            composable(NavRoutes.WISHLISTS) {
                PlaceholderScreen("Wishlists")
            }


            composable(NavRoutes.INBOX) {
                PlaceholderScreen("Inbox")
            }


            composable(NavRoutes.PROFILE) {
                PlaceholderScreen("Profile")
            }
        }
    }
}