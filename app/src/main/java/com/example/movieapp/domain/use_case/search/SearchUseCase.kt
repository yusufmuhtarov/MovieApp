package com.example.movieapp.domain.use_case.search

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.model.movie_models.MovieDomainModel

interface SearchUseCase {
    suspend operator fun invoke(
        textQuery: String
    ) : ResultStatus<List<MovieDomainModel>>
}