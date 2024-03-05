package com.example.movieapp.domain.use_case.top_rated

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.movie_models.MovieDomainModel
import com.example.movieapp.domain.repository.DomainRepository
import javax.inject.Inject

class DefaultTopRatedMovieUseCase @Inject constructor(
    private val repository: DomainRepository
): GetTopRatedMovieUseCase {
    override suspend fun invoke(
    ): ResultStatus<List<MovieDomainModel>>  = repository.getTopRatedMovie()
}