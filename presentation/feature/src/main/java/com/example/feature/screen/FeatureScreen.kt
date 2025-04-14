package com.example.feature.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.feature.contract.event.FeatureEvent
import com.example.feature.viewmodel.FeatureViewModel

@Composable
fun FeatureScreen(viewModel: FeatureViewModel = hiltViewModel()) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    FeatureContent(
        state = state,
        onDeleteMovie = { viewModel.handleEvent(FeatureEvent.OnDeleteMovie(movieId = it)) },
        onSearchMovies = { viewModel.handleEvent(FeatureEvent.OnSearchMovies(text = it)) },
    )
}
