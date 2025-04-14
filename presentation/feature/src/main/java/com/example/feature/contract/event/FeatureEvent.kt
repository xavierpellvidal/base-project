package com.example.feature.contract.event

sealed interface FeatureEvent {
    data class OnSearchMovies(
        val text: String,
    ) : FeatureEvent

    data class OnDeleteMovie(
        val movieId: Int,
    ) : FeatureEvent
}
