package com.example.domain.usecase

import arrow.core.Either
import com.example.domain.repository.MoviesRepository
import javax.inject.Inject

class DeleteMovieUseCase
    @Inject
    constructor(
        private val moviesRepository: MoviesRepository,
    ) {
        suspend operator fun invoke(movieId: Int): Either<Throwable, Unit> =
            moviesRepository.deleteMovie(movieId = movieId)
    }
