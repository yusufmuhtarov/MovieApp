package com.example.movieapp.domain.use_case.now_playing

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.movie_models.MovieDomainModel
import com.example.movieapp.domain.repository.DomainRepository
import javax.inject.Inject

class DefaultNowPlayingMovieUseCase @Inject constructor(
    private val repository: DomainRepository
) : GetNowPlayingMovieUseCase {
    override suspend fun invoke(
    ): ResultStatus<List<MovieDomainModel>> = repository.getNowPlaying()
}
