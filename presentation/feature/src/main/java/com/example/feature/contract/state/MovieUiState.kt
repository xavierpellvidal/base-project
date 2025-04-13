package com.example.feature.contract.state

data class MovieUiState(
    val id: Int,
    val title: String,
    val year: String,
    val type: String,
    val poster: String,
    val movieState: ContentState = ContentState.Idle,
) {
    sealed interface ContentState {
        data object Idle : ContentState

        data object Deleting : ContentState
    }
}
