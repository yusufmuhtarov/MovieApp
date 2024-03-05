package com.example.movieapp.domain.use_case.detail

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.detail_models.MovieDetailDomainModel

interface GetMovieDetailUseCase {
    suspend operator fun invoke(
        movieId: Int
    ): ResultStatus<MovieDetailDomainModel>
}