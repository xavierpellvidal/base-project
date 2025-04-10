package com.example.data.datasource

import arrow.core.Either
import com.example.core.database.model.DeletedMovieEntity
import com.example.data.errors.LocalErrors

internal interface MoviesLocalDataSource {
    fun getDeletedMovies(): Either<LocalErrors, List<DeletedMovieEntity>>

    fun deleteMovie(id: DeletedMovieEntity): Either<LocalErrors, Unit>
}
