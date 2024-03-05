@file:Suppress("KotlinConstantConditions")

package com.example.movieapp.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movieapp.presentation.components.common.LoadedMainScreen
import com.example.movieapp.presentation.components.common.LoadingScreen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeScreenUiState,
    onNavigateToDetailsScreens: (Int) -> Unit,
    onNavigateToSearhScreen: () -> Unit,
    ) {
    when (uiState) {
        is HomeScreenUiState.Success -> {
            LoadedMainScreen(
                uiState = uiState,
                onNavigateToDetailsScreens = onNavigateToDetailsScreens,
                onNavigateToSearchScreen = onNavigateToSearhScreen,
            )
        }

        is HomeScreenUiState.Loading -> LoadingScreen()
        is HomeScreenUiState.Error -> Unit
    }
}