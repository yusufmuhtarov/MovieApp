package com.example.movieapp.di

import com.example.movieapp.data.remote.MovieService
import com.example.movieapp.data.repository.DefaultGetMovieRepository
import com.example.movieapp.domain.repository.DomainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun providesGetPopularMovieRepository(
        service: MovieService
    ): DomainRepository = DefaultGetMovieRepository(
        service = service
    )
}
