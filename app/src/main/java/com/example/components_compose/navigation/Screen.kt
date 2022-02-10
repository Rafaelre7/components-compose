package com.example.components_compose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen (val route: String, val title: String){

    sealed class DrawerScreen(route: String, title: String, val icon: ImageVector
    ): Screen(route, title){
        object Splash: Screen("splash_screen","SplashScreen")
        object HomeScreen: DrawerScreen("HomeScreen", "Home", Icons.Filled.Home)
        object MakeItEasyOne: DrawerScreen("HomeScreen", "MakeItEasyOne", Icons.Filled.Favorite)
        object MakeItEasyTwo: DrawerScreen("HomeScreen", "MakeItEasyTwo", Icons.Filled.Favorite)
        object MakeItEasyThree: DrawerScreen("HomeScreen", "MakeItEasyThree", Icons.Filled.Favorite)
    }
}

val screenDrawer = listOf(
    Screen.DrawerScreen.HomeScreen,
    Screen.DrawerScreen.MakeItEasyOne,
    Screen.DrawerScreen.MakeItEasyTwo,
    Screen.DrawerScreen.MakeItEasyThree
)