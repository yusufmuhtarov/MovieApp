package com.example.movieapp.data.remote

import com.example.movieapp.data.model.detail_model.MovieDetailDataModel
import com.example.movieapp.data.model.movie_model.MovieResponseDataModel
import com.example.movieapp.data.utils.Constants.API_KEY
import com.example.movieapp.data.utils.Constants.FETCH_MOVIE_DETAIL
import com.example.movieapp.data.utils.Constants.FETCH_NOW_PLAYING_MOVIE
import com.example.movieapp.data.utils.Constants.FETCH_POPULAR_MOVIE
import com.example.movieapp.data.utils.Constants.FETCH_TOP_RATED_MOVIE
import com.example.movieapp.data.utils.Constants.FETCH_UPCOMING_MOVIE
import com.example.movieapp.data.utils.Constants.GET_MOVIE_SEARCH_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET(FETCH_POPULAR_MOVIE)
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): Response<MovieResponseDataModel>

    @GET(GET_MOVIE_SEARCH_ID)
    suspend fun searchByQuery(
        @Query("query") textQuery: String,
    ): Response<MovieResponseDataModel>

    @GET(FETCH_MOVIE_DETAIL)
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY,
    ): Response<MovieDetailDataModel>

    @GET(FETCH_NOW_PLAYING_MOVIE)
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): Response<MovieResponseDataModel>

    @GET(FETCH_UPCOMING_MOVIE)
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): Response<MovieResponseDataModel>

    @GET(FETCH_TOP_RATED_MOVIE)
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en"
    ): Response<MovieResponseDataModel>
}