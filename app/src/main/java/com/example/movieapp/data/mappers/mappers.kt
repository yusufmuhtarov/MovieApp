package com.example.movieapp.data.mappers

import com.example.movieapp.data.model.detail_model.DetailResponseModel
import com.example.movieapp.data.model.detail_model.Genre
import com.example.movieapp.data.model.detail_model.MovieDetailDataModel
import com.example.movieapp.data.model.detail_model.SpokenLanguage
import com.example.movieapp.data.model.movie_model.MovieDataModel
import com.example.movieapp.data.model.movie_model.MovieResponseDataModel
import com.example.movieapp.data.utils.Constants.POSTER_PATH_URL
import com.example.movieapp.domain.model.detail_models.DetailResponseModelDomain
import com.example.movieapp.domain.model.detail_models.GenreDomain
import com.example.movieapp.domain.model.detail_models.MovieDetailDomainModel
import com.example.movieapp.domain.model.detail_models.SpokenLanguageDomain
import com.example.movieapp.domain.model.movie_models.MovieDomainModel
import com.example.movieapp.domain.model.movie_models.MovieResponseDomainModel
import com.example.movieapp.presentation.models.detail_models.GenreUi
import com.example.movieapp.presentation.models.detail_models.MovieDetailUiModel
import com.example.movieapp.presentation.models.detail_models.SpokenLanguagesUi
import com.example.movieapp.presentation.models.main_screen_models.MovieResponseUiModel
import com.example.movieapp.presentation.models.main_screen_models.MovieUiModel

fun MovieDataModel.toDomain() = MovieDomainModel(
    movieDescription = movieDescription,
    movieOriginalTitle = movieOriginalTitle,
    movieId = movieId,
    movieName = movieName,
    moviePopularity = moviePopularity,
    movieRealiseDate = movieRealiseDate,
    movieVoteCount = movieVoteCount,
    movieOriginalLanguage = movieOriginalLanguage,
    movieVoteRate = movieVoteRate,
    movieImage = movieImage,
    genre_ids = genre_ids,
    moviePosterImage = moviePosterImage
)

fun MovieDomainModel.toUi() = MovieUiModel(
    movieDescription = movieDescription,
    movieOriginalTitle = movieOriginalTitle,
    movieId = movieId,
    movieName = movieName,
    moviePopularity = moviePopularity,
    movieRealiseDate = movieRealiseDate,
    movieVoteCount = movieVoteCount,
    movieOriginalLanguage = movieOriginalLanguage,
    movieVoteRate = movieVoteRate,
    movieImage = movieImage,
    genre_ids = genre_ids,
    moviePosterImage = moviePosterImage
)

fun MovieResponseDataModel.toDomain() = MovieResponseDomainModel(
    result = result.map { it.toDomain() }
)

fun MovieResponseDomainModel.toUI() = MovieResponseUiModel(
    result = result.map { it.toUi() }
)

fun Genre.toDomain() = GenreDomain(
    id = id,
    name = name,
)

fun GenreDomain.toUi() = GenreUi(
    id = id,
    name = name,
)

fun SpokenLanguage.toDomain() = SpokenLanguageDomain(
    englishName = englishName,
    iso6391 = iso6391,
    name = name
)

fun SpokenLanguageDomain.toUi() = SpokenLanguagesUi(
    englishName = englishName,
    iso6391 = iso6391,
    name = name
)

fun MovieDetailDataModel.toDomain() = MovieDetailDomainModel(
    backdropPath = backdropPath,
    budget = budget,
    title = title,
    genres = genres.map { it.toDomain() },
    status = status,
    releaseDate = releaseDate,
    overview = overview,
    spokenLanguages = spokenLanguages.map { it.toDomain() },
    originalLanguage = originalLanguage,
    popularity = popularity,
    id = id,
    imdbId = imdbId,
    originalTitle = originalTitle,
    revenue = revenue,
    runtime = runtime,
    voteCount = voteCount,
    posterPath = "$POSTER_PATH_URL$posterPath",
    tagline = tagline,
    voteAverage = voteAverage,
    homepage = homepage,
    video = video,
)

fun MovieDetailDomainModel.toUi() = MovieDetailUiModel(
    backdropPath = backdropPath,
    budget = budget,
    title = title,
    genres = genres.map { it.toUi() },
    status = status,
    releaseDate = releaseDate,
    overview = overview,
    spokenLanguages = spokenLanguages.map { it.toUi()},
    originalLanguage = originalLanguage,
    popularity = popularity,
    id = id,
    imdbId = imdbId,
    originalTitle = originalTitle,
    revenue = revenue,
    runtime = runtime,
    voteCount = voteCount,
    posterPath = "$POSTER_PATH_URL$posterPath",
    tagline = tagline,
    voteAverage = voteAverage,
    homepage = homepage,
    video = video,
)


fun DetailResponseModel.toDomain() = DetailResponseModelDomain(
    result = result.toDomain()
)

