package com.example.movieapp.presentation.details_screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.movieapp.presentation.components.common.LoadingScreen

@Composable
fun DetailScreenRealization(
    modifier: Modifier = Modifier,
    uiState: DetailScreenUiState,
    fetchMovie: () -> Unit,
    goToMainScreen: () -> Unit,
) {
    LaunchedEffect(key1 = Unit) { fetchMovie() }
    when (uiState) {
        is DetailScreenUiState.Success -> {
            DetailScreen(
                uiState = uiState,
                goToMainScreen = goToMainScreen
            )
        }

        is DetailScreenUiState.Loading -> {
            LoadingScreen()
        }

        is DetailScreenUiState.Error -> {
        }
    }
}