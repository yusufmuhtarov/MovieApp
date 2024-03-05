package com.example.movieapp.domain.use_case.popular

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.movie_models.MovieDomainModel

interface GetPopularMovieUseCase {
    suspend operator fun invoke(
    ) : ResultStatus<List<MovieDomainModel>>
}