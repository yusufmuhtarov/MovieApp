package com.example.movieapp.di

import com.example.movieapp.data.remote.MovieService
import com.example.movieapp.data.repository.DefaultGetMovieRepository
import com.example.movieapp.data.utils.Constants.API_KEY
import com.example.movieapp.data.utils.Constants.BASE_URL
import com.example.movieapp.domain.repository.DomainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

   @Provides
    fun providesGetPopularMovie(
        service: MovieService
    ) : DomainRepository {
        return DefaultGetMovieRepository(
            service = service,
        )
    }

    @Provides
    fun provideMovieService(
        retrofit: Retrofit
    ) : MovieService{
        return retrofit.create(MovieService::class.java)
    }

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addInterceptor(
                        Interceptor { chain ->
                            val request = chain.request().newBuilder()
                                .addHeader("Authorization", "Bearer $API_KEY").build()
                            return@Interceptor chain.proceed(request = request)
                        },
                    ).build()
            ).build()
    }
}