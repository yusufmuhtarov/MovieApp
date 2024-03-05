package com.example.movieapp.presentation.screen

import androidx.compose.runtime.Immutable
import com.example.movieapp.presentation.models.main_screen_models.MovieUiModel
import kotlinx.collections.immutable.ImmutableList

@Immutable
sealed class HomeScreenUiState {

    @Immutable
    data class Success(
        val popularMovies: ImmutableList<MovieUiModel>,
        val upcomingMovies: ImmutableList<MovieUiModel>,
        val nowPlayingMovies: ImmutableList<MovieUiModel>,
        val topRatedMovies: ImmutableList<MovieUiModel>,
    ) : HomeScreenUiState()

    data object Loading : HomeScreenUiState()

    @Immutable
    data class Error(
        val message: String
    ) : HomeScreenUiState()

}

