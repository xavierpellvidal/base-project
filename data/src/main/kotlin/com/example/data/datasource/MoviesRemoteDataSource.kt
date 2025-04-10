package com.example.data.datasource

import arrow.core.Either
import com.example.core.api.model.MovieDto
import com.example.data.errors.RemoteErrors

internal interface MoviesRemoteDataSource {
    suspend fun searchMovies(
        query: String,
        size: Int,
    ): Either<RemoteErrors, List<MovieDto>>
}
