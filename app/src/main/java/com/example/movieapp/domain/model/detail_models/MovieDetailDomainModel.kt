package com.example.movieapp.domain.model.detail_models

data class MovieDetailDomainModel(
    val backdropPath: String,
    val budget: Int,
    val genres: List<GenreDomain>,
    val homepage: String,
    val id: Int?,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguageDomain>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)
