package com.example.feature.contract.state

import com.example.domain.model.Movie

data class FeatureUiState(
    val movies: List<Movie> = emptyList(),
    val contentState: ContentState = ContentState.Idle,
) {
    sealed interface ContentState {
        data object Idle : ContentState

        data object Loading : ContentState
    }
}
