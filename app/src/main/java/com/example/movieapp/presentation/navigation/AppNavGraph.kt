package com.example.movieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.presentation.bottom_bar.BottomNavHost
import com.example.movieapp.presentation.bottom_bar.mainNavHost
import com.example.movieapp.presentation.components.common.SplashScreen
import com.example.movieapp.presentation.components.common.SplashScreenDestination

@Composable
fun AppNavGraph() {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = SplashScreenDestination.route,
    ) {
        composable(
            SplashScreenDestination.route
        ) {
            SplashScreen(
                onNavigateNext = {
                    navController.navigate(mainNavHost)
                },
            )
        }
        composable(
            mainNavHost
        ) {
            BottomNavHost()
        }
    }
}

