package com.example.movieapp.di

import com.example.movieapp.data.repository.DefaultGetMovieRepository
import com.example.movieapp.domain.repository.DomainRepository
import com.example.movieapp.domain.use_case.detail.DefaultGetMovieDetail
import com.example.movieapp.domain.use_case.detail.GetMovieDetailUseCase
import com.example.movieapp.domain.use_case.now_playing.DefaultNowPlayingMovieUseCase
import com.example.movieapp.domain.use_case.now_playing.GetNowPlayingMovieUseCase
import com.example.movieapp.domain.use_case.popular.DefaultGetPopularMovieImpl
import com.example.movieapp.domain.use_case.popular.GetPopularMovieUseCase
import com.example.movieapp.domain.use_case.search.SearchMovieImpl
import com.example.movieapp.domain.use_case.search.SearchUseCase
import com.example.movieapp.domain.use_case.top_rated.DefaultTopRatedMovieUseCase
import com.example.movieapp.domain.use_case.top_rated.GetTopRatedMovieUseCase
import com.example.movieapp.domain.use_case.upcoming.DefaultUpcomingMovieUseCase
import com.example.movieapp.domain.use_case.upcoming.GetUpcomingMovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideGetPopularMovieUseCase(
        repository: DefaultGetMovieRepository
    ): GetPopularMovieUseCase = DefaultGetPopularMovieImpl(
        repository = repository
    )

    @Provides
    fun provideSearch(
        repository: DefaultGetMovieRepository
    ): SearchUseCase = SearchMovieImpl(
        repository = repository
    )

    @Provides
    fun provideGetTopRatedMovieUseCase(
        repository: DefaultGetMovieRepository
    ): GetTopRatedMovieUseCase = DefaultTopRatedMovieUseCase(
        repository = repository
    )

    @Provides
    fun provideGetUpcomingMoviesUseCase(
        repository: DefaultGetMovieRepository
    ): GetUpcomingMovieUseCase = DefaultUpcomingMovieUseCase(
        repository = repository
    )

    @Provides
    fun provideGetNowPlayingUseCase(
        repository: DefaultGetMovieRepository
    ): GetNowPlayingMovieUseCase = DefaultNowPlayingMovieUseCase(
        repository = repository
    )

    @Provides
    fun provideGetDetailMovieUseCase(
        repository: DefaultGetMovieRepository
    ): GetMovieDetailUseCase = DefaultGetMovieDetail(
        repository = repository
    )
}