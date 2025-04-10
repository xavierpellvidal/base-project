package com.example.data.datasource

import com.example.core.api.service.MovieApi
import com.example.data.errors.RemoteErrors

internal class MoviesApiDataSource(
    private val moviesApi: MovieApi,
) : MoviesRemoteDataSource {
    override suspend fun searchMovies(
        query: String,
        size: Int,
    ) = moviesApi
        .searchMovies(query = query, page = size)
        .map { it.results }
        .mapLeft { RemoteErrors.NetworkException }
}
