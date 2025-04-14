package com.example.data.datasource

import arrow.core.Either
import com.example.core.database.dao.MovieDao
import com.example.core.database.model.DeletedMovieEntity
import com.example.data.errors.LocalErrors
import javax.inject.Inject

class MoviesDatabaseDataSource
    @Inject
    constructor(
        private val movieDao: MovieDao,
    ) : MoviesLocalDataSource {
        override suspend fun getDeletedMovies(): Either<LocalErrors, List<DeletedMovieEntity>> =
            Either
                .catch {
                    movieDao.getAllDeletedMovies()
                }.mapLeft { LocalErrors.DatabaseException }

        override suspend fun deleteMovie(id: DeletedMovieEntity) =
            Either
                .catch {
                    movieDao.insertDeletedMovie(id)
                }.mapLeft { LocalErrors.DatabaseException }
    }
