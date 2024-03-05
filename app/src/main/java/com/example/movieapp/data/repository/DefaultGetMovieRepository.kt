package com.example.movieapp.data.repository

import com.example.movieapp.data.base.model.BasedDataSource
import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.data.mappers.toDomain
import com.example.movieapp.data.model.movie_model.MovieResponseDataModel
import com.example.movieapp.data.remote.MovieService
import com.example.movieapp.domain.model.detail_models.MovieDetailDomainModel
import com.example.movieapp.domain.model.movie_models.MovieDomainModel
import com.example.movieapp.domain.repository.DomainRepository
import javax.inject.Inject

class DefaultGetMovieRepository @Inject constructor(
    private val service: MovieService,
) : DomainRepository, BasedDataSource() {

    override suspend fun getPopularMovieRepository(
    ): ResultStatus<List<MovieDomainModel>> {
        val response = invokeResponseRequest {
            service.getPopularMovies()
        }
        return ResultStatus(
            status = response.status,
            data = response.data?.result?.map { it.toDomain() },
            errorThrowable = response.errorThrowable,
        )
    }

    override suspend fun getTopRatedMovie(
    ): ResultStatus<List<MovieDomainModel>> {
        val response = invokeResponseRequest {
            service.getTopRatedMovies(
            )
        }
        return ResultStatus(
            status = response.status,
            data = response.data?.result?.map { it.toDomain() },
            errorThrowable = response.errorThrowable,
        )
    }

    override suspend fun getUpcomingMovie(
    ): ResultStatus<List<MovieDomainModel>> {
        val response = invokeResponseRequest {
            service.getUpcomingMovies()
        }
        return ResultStatus(
            status = response.status,
            data = response.data?.result?.map { it.toDomain() },
            errorThrowable = response.errorThrowable,
        )
    }

    override suspend fun getNowPlaying(): ResultStatus<List<MovieDomainModel>> {
        val response = invokeResponseRequest {
            service.getNowPlayingMovies()
        }
        return ResultStatus(
            status = response.status,
            data = response.data?.result?.map { it.toDomain() },
            errorThrowable = response.errorThrowable,
        )
    }

    override suspend fun getMovieDetail(movieId: Int): ResultStatus<MovieDetailDomainModel> {
        val response = invokeResponseRequest {
            service.getMovieDetail(movieId = movieId)
        }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.toDomain()
        )
    }

    override suspend fun searchByTitle(textQuery: String): ResultStatus<List<MovieDomainModel>> {
        val response = invokeResponseRequest {
            service.searchByQuery(textQuery = textQuery)
        }
        return ResultStatus(
            status =  response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.result?.map { it.toDomain() }
        )
    }
}