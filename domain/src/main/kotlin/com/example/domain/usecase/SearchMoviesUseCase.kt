package com.example.domain.usecase

import arrow.core.Either
import arrow.core.flatMap
import com.example.domain.model.Movie
import com.example.domain.repository.MoviesRepository
import javax.inject.Inject

class SearchMoviesUseCase
    @Inject
    constructor(
        private val moviesRepository: MoviesRepository,
    ) {
        suspend operator fun invoke(
            query: String,
            page: Int,
        ): Either<Throwable, List<Movie>> =
            moviesRepository.searchMovies(query, page).flatMap { movies ->
                moviesRepository.getDeletedMovies().fold(
                    ifLeft = {
                        Either.Right(movies)
                    },
                    ifRight = { deletedIds ->
                        Either.Right(movies.filterNot { it.id.toInt() in deletedIds.toSet() })
                    },
                )
            }
    }
