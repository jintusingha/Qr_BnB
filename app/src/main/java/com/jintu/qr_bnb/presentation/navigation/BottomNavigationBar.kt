package com.jintu.qr_bnb.presentation.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jintu.qr_bnb.R

@Composable
fun AppBottomNavBarLabel(text: String) {
    Text(text = text)
}

// uri based navigation
// we have to use data class based navigation

@Composable
fun BottomNavigationBar(navController: NavController) {


    val colors = navItemColors()

    NavigationBar(
        containerColor = Color.White
    ) {


        NavigationBarItem(
            selected = false,
            onClick = {

                navController.navigate(NavRoutes.HOME)
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Home",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Gray
                )
            },
            label = { AppBottomNavBarLabel("Home") },
            colors = colors
        )


        NavigationBarItem(
            selected = false,
            onClick = {

                navController.navigate(NavRoutes.EXPLORE)
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Explore",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Gray
                )
            },
            label = { AppBottomNavBarLabel("Explore") },
            colors = colors
        )


        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(NavRoutes.WISHLISTS)
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.wishlist),
                    contentDescription = "Wishlists",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Gray
                )
            },
            label = { AppBottomNavBarLabel("Wishlists") },
            colors = colors
        )


        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(NavRoutes.INBOX)
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.inbox),
                    contentDescription = "Inbox",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Gray
                )
            },
            label = { AppBottomNavBarLabel("Inbox") },
            colors = colors
        )


        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(NavRoutes.PROFILE)
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Gray
                )
            },
            label = { AppBottomNavBarLabel("Profile") },
            colors = colors
        )
    }
}


@Composable
private fun navItemColors() = NavigationBarItemDefaults.colors()