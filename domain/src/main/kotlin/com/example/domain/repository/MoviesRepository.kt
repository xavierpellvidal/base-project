package com.example.domain.repository

import arrow.core.Either
import com.example.domain.model.Movie

interface MoviesRepository {
    suspend fun searchMovies(
        query: String,
        size: Int,
    ): Either<Throwable, List<Movie>>

    fun getDeletedMovies(): Either<Throwable, List<Int>>

    fun deleteMovie(movieId: Int): Either<Throwable, Unit>
}
