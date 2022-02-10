package com.example.components_compose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen (val route: String, val title: String){

    sealed class DrawerScreen(route: String, title: String, val icon: ImageVector
    ): Screen(route, title){
        object Splash: Screen("splash_screen","SplashScreen")
        object HomeScreen: DrawerScreen("HomeScreen", "Home", Icons.Filled.Home)
        object Favoritos: DrawerScreen("Favoritos", "Favoritos", Icons.Filled.Favorite)
        object Email: DrawerScreen("Email", "Email", Icons.Filled.Email)
        object Buscar: DrawerScreen("Buscar", "Buscar", Icons.Filled.Search)
    }
}

val screenDrawer = listOf(
    Screen.DrawerScreen.HomeScreen,
    Screen.DrawerScreen.Favoritos,
    Screen.DrawerScreen.Email,
    Screen.DrawerScreen.Buscar
)