package com.example.movieapp.presentation.navigation

import com.example.movieapp.R


sealed class Screens(
    val route: String
) {
    data object SplashScreen : Screens(R.string.splash_screen.toString())

    data object HomeScreen : Screens(R.string.home_screen.toString())

    data object DetailScreen: Screens(R.string.detail_screen.toString())

}