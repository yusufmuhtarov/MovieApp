package com.example.movieapp.domain.use_case.now_playing

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.data.model.detail_model.MovieDetailDataModel
import com.example.movieapp.domain.model.detail_models.MovieDetailDomainModel
import com.example.movieapp.domain.model.movie_models.MovieDomainModel

interface GetNowPlayingMovieUseCase {
    suspend operator fun invoke(
    ) : ResultStatus<List<MovieDomainModel>>
}