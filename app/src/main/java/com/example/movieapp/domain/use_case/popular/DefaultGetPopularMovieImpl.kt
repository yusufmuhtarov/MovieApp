package com.example.movieapp.domain.use_case.popular

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.movie_models.MovieDomainModel
import com.example.movieapp.domain.repository.DomainRepository
import javax.inject.Inject

class DefaultGetPopularMovieImpl @Inject constructor(
    private val repository: DomainRepository
): GetPopularMovieUseCase {
    override suspend fun invoke(): ResultStatus<List<MovieDomainModel>> = repository.getPopularMovieRepository()
}