package com.example.feature.contract.state

data class MovieUiState(
    val id: String,
    val title: String,
    val year: String,
    val type: String,
    val poster: String,
    val movieState: ContentState = ContentState.Idle,
) {
    sealed interface ContentState {
        data object Idle : ContentState

        data class Deleting(
            val movieId: Int,
        ) : ContentState
    }
}
