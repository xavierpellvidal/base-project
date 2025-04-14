package com.example.feature.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.presentation.ui.theme.BaseProjectTheme
import com.example.feature.contract.state.FeatureUiState
import com.example.feature.contract.state.MovieUiState

@Composable
internal fun FeatureContent(
    state: FeatureUiState,
    onDeleteMovie: (Int) -> Unit,
    onSearchMovies: (String) -> Unit,
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        when (state.contentState) {
            is FeatureUiState.ContentState.Idle -> {
                FeatureIdleContent(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                    movies = state.movies,
                    onDeleteMovie = onDeleteMovie,
                    onSearchMovies = onSearchMovies,
                )
            }

            is FeatureUiState.ContentState.Loading -> {
                Box(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator(
                        strokeWidth = 6.dp,
                    )
                }
            }
        }
    }
}

@Composable
private fun FeatureIdleContent(
    modifier: Modifier,
    movies: List<MovieUiState>,
    onDeleteMovie: (Int) -> Unit,
    onSearchMovies: (String) -> Unit,
) {
}

@Preview
@Composable
private fun LoadingStatePreview() {
    BaseProjectTheme {
        FeatureContent(
            state =
                FeatureUiState(
                    contentState = FeatureUiState.ContentState.Loading,
                ),
            onDeleteMovie = {},
            onSearchMovies = {},
        )
    }
}
