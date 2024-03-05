package com.example.movieapp.domain.model.movie_models

import com.example.movieapp.domain.model.movie_models.MovieDomainModel
import java.io.Serializable

data class MovieResponseDomainModel(
    val result: List<MovieDomainModel>
): Serializable



