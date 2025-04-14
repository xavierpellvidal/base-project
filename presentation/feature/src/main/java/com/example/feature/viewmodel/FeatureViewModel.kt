package com.example.feature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.DeleteMovieUseCase
import com.example.domain.usecase.SearchMoviesUseCase
import com.example.feature.contract.event.FeatureEvent
import com.example.feature.contract.state.FeatureUiState
import com.example.feature.contract.state.MovieUiState
import com.example.feature.mapper.toUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
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

        private fun searchMovies(text: String) {
            viewModelScope.launch {
                searchMoviesUseCase(query = text, page = 0).fold(
                    ifLeft = {
                        _uiState.update { state ->
                            state.copy(
                                movies = emptyList(),
                            )
                        }
                        // TODO send error searching movies
                    },
                    ifRight = { movies ->
                        _uiState.update { state ->
                            state.copy(
                                movies = state.movies + movies.toUiState(),
                            )
                        }
                    },
                )
            }
        }

        private fun deleteMovie(movieId: Int) {
            _uiState.update { state ->
                state.copy(
                    movies =
                        state.movies.updateMovie(movieId) { movie ->
                            movie.copy(
                                movieState = MovieUiState.ContentState.Deleting,
                            )
                        },
                )
            }
            viewModelScope.launch {
                deleteMovieUseCase(movieId = movieId).fold(
                    ifLeft = {
                        _uiState.update { state ->
                            state.copy(
                                movies =
                                    state.movies.updateMovie(movieId) { movie ->
                                        movie.copy(movieState = MovieUiState.ContentState.Idle)
                                    },
                            )
                        }
                        // TODO send error deleting movie
                    },
                    ifRight = { _ ->
                        _uiState.update { state ->
                            state.copy(
                                movies = state.movies.filterNot { it.id == movieId },
                            )
                        }
                    },
                )
            }
        }
    }

private fun List<MovieUiState>.updateMovie(
    id: Int,
    updateMovie: (MovieUiState) -> MovieUiState,
): List<MovieUiState> =
    map { movie ->
        if (movie.id == id) updateMovie(movie) else movie
    }
