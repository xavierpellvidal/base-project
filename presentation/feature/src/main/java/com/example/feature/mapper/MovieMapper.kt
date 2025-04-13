package com.example.feature.mapper

import com.example.domain.model.Movie
import com.example.feature.contract.state.MovieUiState

fun List<Movie>.toUiState() = map { it.toUiState() }

fun Movie.toUiState() =
    MovieUiState(
        id = id,
        title = title,
        year = year,
        type = type,
        poster = poster,
    )
