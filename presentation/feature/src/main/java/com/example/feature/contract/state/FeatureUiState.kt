package com.example.feature.contract.state

data class FeatureUiState(
    val movies: List<MovieUiState> = emptyList(),
    val contentState: ContentState = ContentState.Idle,
) {
    sealed interface ContentState {
        data object Idle : ContentState

        data object Loading : ContentState
    }
}
