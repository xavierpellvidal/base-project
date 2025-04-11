package com.example.data.datasource

import arrow.core.Either
import com.example.core.database.model.DeletedMovieEntity
import com.example.data.errors.LocalErrors

interface MoviesLocalDataSource {
    suspend fun getDeletedMovies(): Either<LocalErrors, List<DeletedMovieEntity>>

    suspend fun deleteMovie(id: DeletedMovieEntity): Either<LocalErrors, Unit>
}
