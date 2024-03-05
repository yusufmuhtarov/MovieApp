package com.example.movieapp.domain.repository

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.detail_models.MovieDetailDomainModel
import com.example.movieapp.domain.model.movie_models.MovieDomainModel
import com.example.movieapp.domain.model.movie_models.MovieResponseDomainModel
import retrofit2.http.Query

interface DomainRepository {
    suspend fun getPopularMovieRepository(
    ): ResultStatus<List<MovieDomainModel>>

    suspend fun getTopRatedMovie(
    ): ResultStatus<List<MovieDomainModel>>

    suspend fun getUpcomingMovie(
    ): ResultStatus<List<MovieDomainModel>>

    suspend fun getNowPlaying(
    ): ResultStatus<List<MovieDomainModel>>

    suspend fun getMovieDetail(
        movieId: Int
    ): ResultStatus<MovieDetailDomainModel>

    suspend fun searchByTitle(
        textQuery: String
    ) : ResultStatus<List<MovieDomainModel>>
}