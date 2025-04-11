package com.example.feature.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.ui.theme.BaseProjectTheme
import com.example.feature.components.FeatureContent
import com.example.feature.contract.event.FeatureEvent
import com.example.feature.contract.state.FeatureUiState
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

@Preview
@Composable
private fun WakeupScreenUpdatingStatePreview() {
    BaseProjectTheme {
        FeatureContent(
            state = FeatureUiState(),
            onDeleteMovie = {},
            onSearchMovies = {},
        )
    }
}
