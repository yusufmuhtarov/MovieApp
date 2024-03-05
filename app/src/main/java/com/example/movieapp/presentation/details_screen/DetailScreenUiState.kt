package com.example.movieapp.presentation.details_screen

import com.example.movieapp.domain.model.detail_models.MovieDetailDomainModel
import com.example.movieapp.presentation.models.detail_models.MovieDetailUiModel
import javax.annotation.concurrent.Immutable

@Immutable
sealed class DetailScreenUiState {

    @Immutable
    data class Success(
        val movieDetail: MovieDetailUiModel
    ) : DetailScreenUiState()

    data object Loading : DetailScreenUiState()

    data class Error(
        val message: String
    ) : DetailScreenUiState()
}