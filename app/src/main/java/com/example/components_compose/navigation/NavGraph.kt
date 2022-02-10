package com.example.components_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.components_compose.AnimatedSplashScreen
import com.example.components_compose.NavigationDrawer

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.DrawerScreen.Splash.route
    ){
        composable(route = Screen.DrawerScreen.Splash.route){
            AnimatedSplashScreen(navController = navController)
        }
        composable(route = Screen.DrawerScreen.HomeScreen.route){
            NavigationDrawer(navController = navController)
        }
        composable(route = Screen.DrawerScreen.Favoritos.route){
            NavigationDrawer(navController = navController)
        }

        composable(route = Screen.DrawerScreen.Email.route){
            NavigationDrawer(navController = navController)
        }

        composable(route = Screen.DrawerScreen.Buscar.route){
            NavigationDrawer(navController = navController)
        }
    }


}