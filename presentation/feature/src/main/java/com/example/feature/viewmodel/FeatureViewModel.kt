package com.example.feature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.DeleteMovieUseCase
import com.example.domain.usecase.SearchMoviesUseCase
import com.example.feature.contract.event.FeatureEvent
import com.example.feature.contract.state.FeatureUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeatureViewModel
    @Inject
    constructor(
        private val deleteMovieUseCase: DeleteMovieUseCase,
        private val searchMoviesUseCase: SearchMoviesUseCase,
    ) : ViewModel() {
        private val _uiState: MutableStateFlow<FeatureUiState> = MutableStateFlow(FeatureUiState())
        val uiState: StateFlow<FeatureUiState> = _uiState

        fun handleEvent(event: FeatureEvent) {
            when (event) {
                is FeatureEvent.OnSearchMovies -> {
                    searchMovies(text = event.text)
                }

                is FeatureEvent.OnDeleteMovie -> {
                    deleteMovie(movieId = event.movieId)
                }
            }
        }

        fun searchMovies(text: String) {
            viewModelScope.launch {
                searchMoviesUseCase(query = text, page = 0)
            }
        }

        fun deleteMovie(movieId: Int) {
            viewModelScope.launch {
                deleteMovieUseCase(movieId = movieId)
            }
        }
    }
