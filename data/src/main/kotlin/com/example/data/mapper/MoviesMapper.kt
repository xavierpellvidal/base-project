package com.example.data.mapper

import com.example.core.api.model.MovieDto
import com.example.core.database.model.DeletedMovieEntity
import com.example.domain.model.Movie

fun List<MovieDto>.toDomain() = map { it.toDomain() }

fun MovieDto.toDomain() =
    Movie(
        id = imdbId,
        title = title,
        year = year,
        type = type,
        poster = poster,
    )

fun List<DeletedMovieEntity>.toDomain() = map { it.toDomain() }

fun DeletedMovieEntity.toDomain() = id
