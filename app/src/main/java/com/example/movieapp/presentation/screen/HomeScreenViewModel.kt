package com.example.movieapp.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.base.model.ResponseStatus
import com.example.movieapp.data.mappers.toUi
import com.example.movieapp.domain.use_case.now_playing.GetNowPlayingMovieUseCase
import com.example.movieapp.domain.use_case.popular.GetPopularMovieUseCase
import com.example.movieapp.domain.use_case.top_rated.GetTopRatedMovieUseCase
import com.example.movieapp.domain.use_case.upcoming.GetUpcomingMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getPopularMovieUseCase: GetPopularMovieUseCase,
    private val getTopRatedMovieUseCase: GetTopRatedMovieUseCase,
    private val getNowPlayingMovieUseCase: GetNowPlayingMovieUseCase,
    private val getUpcomingMovieUseCase: GetUpcomingMovieUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeScreenUiState>(HomeScreenUiState.Loading)
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()
    private val handle = CoroutineExceptionHandler { _, throwable -> }

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch(handle + Dispatchers.IO) {
            val popularResponse = getPopularMovieUseCase()
            val upcomingUseCase = getUpcomingMovieUseCase()
            val nowPLayingResponse = getNowPlayingMovieUseCase()
            val topRatedResponse = getTopRatedMovieUseCase()
            if (
                popularResponse.status == ResponseStatus.SUCCESS &&
                topRatedResponse.status == ResponseStatus.SUCCESS &&
                upcomingUseCase.status == ResponseStatus.SUCCESS &&
                nowPLayingResponse.status == ResponseStatus.SUCCESS
            ) {
                popularResponse.data?.let { popularMovies ->
                    upcomingUseCase.data?.let { upcomingMovies ->
                        topRatedResponse.data?.let { topRatedMovies ->
                            nowPLayingResponse.data?.let { nowPlayingMovies ->
                                _uiState.update {
                                    HomeScreenUiState.Success(
                                        popularMovies = popularMovies.map { it.toUi() }
                                            .toImmutableList(),
                                        upcomingMovies = upcomingMovies.map { it.toUi() }
                                            .toImmutableList(),
                                        topRatedMovies = topRatedMovies.map { it.toUi() }
                                            .toImmutableList(),
                                        nowPlayingMovies = nowPlayingMovies.map { it.toUi() }
                                            .toImmutableList(),
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}