package com.example.feature.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.feature.contract.state.FeatureUiState

@Composable
internal fun FeatureContent(
    state: FeatureUiState,
    onDeleteMovie: (Int) -> Unit,
    onSearchMovies: (String) -> Unit,
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    }
}
