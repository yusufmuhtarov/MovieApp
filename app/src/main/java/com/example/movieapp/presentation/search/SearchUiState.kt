package com.example.movieapp.presentation.search

import com.example.movieapp.presentation.models.main_screen_models.MovieUiModel
import kotlinx.collections.immutable.ImmutableList

sealed class SearchUiState {

    data class Success(
        val model: ImmutableList<MovieUiModel>,
        val query: String,
    ) : SearchUiState()

    data object Loading : SearchUiState()

    data object Install: SearchUiState()
    data class Error(
        val message: String
    ) : SearchUiState()
}