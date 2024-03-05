package com.example.movieapp.data.model.movie_model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieResponseDataModel(
    @SerializedName("results")
    val result: List<MovieDataModel>
) : Serializable