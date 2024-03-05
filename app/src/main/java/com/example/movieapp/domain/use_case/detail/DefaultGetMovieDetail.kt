package com.example.movieapp.domain.use_case.detail

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.detail_models.MovieDetailDomainModel
import com.example.movieapp.domain.repository.DomainRepository
import javax.inject.Inject

class DefaultGetMovieDetail @Inject constructor(
    private val repository: DomainRepository,
) : GetMovieDetailUseCase {
    override suspend fun invoke(movieId: Int): ResultStatus<MovieDetailDomainModel> =
        repository.getMovieDetail(movieId = movieId)
}