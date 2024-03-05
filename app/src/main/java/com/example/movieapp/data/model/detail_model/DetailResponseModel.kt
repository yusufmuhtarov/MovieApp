package com.example.movieapp.data.model.detail_model

import com.google.gson.annotations.SerializedName

data class DetailResponseModel (
    @SerializedName("results")
    val result: MovieDetailDataModel
)