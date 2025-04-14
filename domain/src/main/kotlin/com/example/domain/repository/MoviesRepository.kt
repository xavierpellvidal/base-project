package com.example.domain.repository

import arrow.core.Either
import com.example.domain.model.Movie

interface MoviesRepository {
    suspend fun searchMovies(
        query: String,
        page: Int,
    ): Either<Throwable, List<Movie>>

    suspend fun getDeletedMovies(): Either<Throwable, List<Int>>

    suspend fun deleteMovie(movieId: Int): Either<Throwable, Unit>
}
