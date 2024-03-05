package com.example.movieapp.presentation.details_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.base.model.ResponseStatus
import com.example.movieapp.data.mappers.toUi
import com.example.movieapp.domain.use_case.detail.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val getDetailUseCase: GetMovieDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailScreenUiState>(DetailScreenUiState.Loading)
    val uiState: StateFlow<DetailScreenUiState> = _uiState.asStateFlow()
    private val handle = CoroutineExceptionHandler { _, throwable -> }


    fun fetchDetails(movieId: Int) {
        viewModelScope.launch(handle + Dispatchers.IO) {
            val detailResponse = getDetailUseCase.  invoke(movieId = movieId)
            if (detailResponse.status == ResponseStatus.SUCCESS) {
                detailResponse.data?.let { movieDetailDomainModels ->
                    _uiState.update {
                        DetailScreenUiState.Success(
                            movieDetail = movieDetailDomainModels.toUi()
                        )
                    }
                }
            }
        }
    }
}