package com.example.movieapp.data.model.movie_model

import com.example.movieapp.data.utils.Constants
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieDataModel(
    @SerializedName("poster_path")
    val moviePosterImage: String,
    @SerializedName("original_title")
    val movieOriginalTitle: String,
    @SerializedName("title")
    val movieName: String,
    @SerializedName("backdrop_path")
    val movieImage: String,
    @SerializedName("id")
    val movieId: Int,
    @SerializedName("genre_ids")
    val genre_ids: List<Int>,
    @SerializedName("original_language")
    val movieOriginalLanguage: String,
    @SerializedName("overview")
    val movieDescription: String,
    @SerializedName("popularity")
    val moviePopularity: Double,
    @SerializedName("release_date")
    val movieRealiseDate: String,
    @SerializedName("vote_average")
    val movieVoteRate: Double,
    @SerializedName("vote_count")
    val movieVoteCount: Int,
) : Serializable {
    companion object {
        val unknown = MovieDataModel(
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
