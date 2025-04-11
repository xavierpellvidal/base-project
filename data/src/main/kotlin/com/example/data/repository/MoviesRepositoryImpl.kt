package com.example.data.repository

import com.example.core.database.model.DeletedMovieEntity
import com.example.data.datasource.MoviesLocalDataSource
import com.example.data.datasource.MoviesRemoteDataSource
import com.example.data.mapper.toDomain
import com.example.domain.repository.MoviesRepository
import javax.inject.Inject

internal class MoviesRepositoryImpl
    @Inject
    constructor(
        private val moviesRemoteDataSource: MoviesRemoteDataSource,
        private val moviesLocalDataSource: MoviesLocalDataSource,
    ) : MoviesRepository {
        override suspend fun searchMovies(
            query: String,
            page: Int,
        ) = moviesRemoteDataSource.searchMovies(query = query, page = page).map { list -> list.toDomain() }

        override suspend fun getDeletedMovies() =
            moviesLocalDataSource.getDeletedMovies().map { list -> list.toDomain() }

        override suspend fun deleteMovie(movieId: Int) =
            moviesLocalDataSource.deleteMovie(DeletedMovieEntity(id = movieId))
    }
