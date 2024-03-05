package com.example.movieapp.domain.use_case.search

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.data.repository.DefaultGetMovieRepository
import com.example.movieapp.domain.model.movie_models.MovieDomainModel
import com.example.movieapp.domain.repository.DomainRepository

class SearchMovieImpl(
    private val repository: DomainRepository
) : SearchUseCase {
    override suspend fun invoke(textQuery: String): ResultStatus<List<MovieDomainModel>> =
        repository.searchByTitle(
            textQuery = textQuery
        )
}