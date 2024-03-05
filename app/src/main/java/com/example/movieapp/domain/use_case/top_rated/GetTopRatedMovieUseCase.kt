package com.example.movieapp.domain.use_case.top_rated

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.movie_models.MovieDomainModel

interface GetTopRatedMovieUseCase {
    suspend operator fun invoke(
    ) : ResultStatus<List<MovieDomainModel>>
}