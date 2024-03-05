package com.example.movieapp.presentation.models.main_screen_models

import java.io.Serializable

data class MovieResponseUiModel(
    val result: List<MovieUiModel>
): Serializable
