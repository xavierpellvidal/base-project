package com.example.data.datasource

import arrow.core.Either
import com.example.core.api.model.MovieDto
import com.example.data.errors.RemoteErrors

interface MoviesRemoteDataSource {
    suspend fun searchMovies(
        query: String,
        page: Int,
    ): Either<RemoteErrors, List<MovieDto>>
}
