package com.example.movieapp.presentation.bottom_bar

import SearchScreen
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.presentation.details_screen.DetailScreenRealization
import com.example.movieapp.presentation.details_screen.DetailScreenViewModel
import com.example.movieapp.presentation.details_screen.DetailsScreenDestination
import com.example.movieapp.presentation.screen.HomeScreen
import com.example.movieapp.presentation.screen.HomeScreenViewModel
import com.example.movieapp.presentation.search.SearchViewModel
import com.example.movieapp.presentation.watch.list.WatchListScreen

const val mainNavHost = "MAIN_HAV_HOST"

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavHost() {
    val listItems = listOf(
        BottomBarScreens.Home,
        BottomBarScreens.Search,
        BottomBarScreens.WatchList
    )
    val navHostController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationScreen(
                navController = navHostController,
                items = listItems
            )
        },
    ) { innerPadding ->
        NavHost(
            navController = navHostController,
            startDestination = BottomBarScreens.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = BottomBarScreens.Home.route) {
                val viewModel: HomeScreenViewModel = hiltViewModel()
                HomeScreen(
                    uiState = viewModel.uiState.collectAsState().value,
                    onNavigateToDetailsScreens = { movieId ->
                        navHostController.navigate("${DetailsScreenDestination.route}/$movieId")
                    },
                    onNavigateToSearhScreen = { navHostController.navigate(BottomBarScreens.Search.route) }
                )
            }
            composable(route = BottomBarScreens.Search.route) {
                val viewModel: SearchViewModel = hiltViewModel()
                SearchScreen(
                    goToMainScreen = {
                        navHostController.navigate(BottomBarScreens.Home.route)
                    },
                )
            }
            composable(route = BottomBarScreens.WatchList.route) {
                WatchListScreen()
            }
            composable(
                route = DetailsScreenDestination.routeWithArgs,
                arguments = DetailsScreenDestination.arguments,
            ) { navBackStackEntry ->
                val movieId = navBackStackEntry.arguments?.getInt(DetailsScreenDestination.movieId) ?: 0
                val viewModel: DetailScreenViewModel = hiltViewModel()
                DetailScreenRealization(
                    uiState = viewModel.uiState.collectAsState().value,
                    fetchMovie = {
                        viewModel.fetchDetails(movieId = movieId)
                    },
                    goToMainScreen = {
                        navHostController.navigate(BottomBarScreens.Home.route)
                    }
                )
            }
        }
    }
}
