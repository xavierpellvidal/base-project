package com.example.feature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.DeleteMovieUseCase
import com.example.domain.usecase.SearchMoviesUseCase
import com.example.feature.contract.event.FeatureEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeatureViewModel
    @Inject
    constructor(
        private val deleteMovieUseCase: DeleteMovieUseCase,
        private val searchMoviesUseCase: SearchMoviesUseCase,
    ) : ViewModel() {
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
