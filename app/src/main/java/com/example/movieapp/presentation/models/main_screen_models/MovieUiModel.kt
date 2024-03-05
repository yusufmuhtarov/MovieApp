package com.example.movieapp.presentation.models.main_screen_models

import com.example.movieapp.data.utils.Constants
import java.io.Serializable

data class MovieUiModel (
    val movieName: String,
    val movieImage: String,
    val moviePosterImage: String,
    val movieId: Int,
    val movieOriginalTitle: String,
    val genre_ids: List<Int>,
    val movieOriginalLanguage: String,
    val movieDescription: String,
    val moviePopularity: Double,
    val movieRealiseDate: String,
    val movieVoteRate: Double,
    val movieVoteCount: Int,
) : Serializable {
    companion object {
        val unknown = MovieUiModel(
            movieImage = Constants.EMPTY_STRING,
            movieId = 0,
            movieOriginalTitle = Constants.EMPTY_STRING,
            movieDescription = Constants.EMPTY_STRING,
            movieName = Constants.EMPTY_STRING,
            moviePopularity = 0.0,
            movieRealiseDate = Constants.EMPTY_STRING,
            movieVoteCount = 0,
            movieOriginalLanguage = Constants.EMPTY_STRING,
            movieVoteRate = 0.0,
            genre_ids = listOf(),
            moviePosterImage = ""
        )
    }
}