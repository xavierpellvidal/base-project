package com.example.domain.di

import com.example.domain.repository.MoviesRepository
import com.example.domain.usecase.DeleteMovieUseCase
import com.example.domain.usecase.SearchMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
object DomainModule {
    @Provides
    fun provideSearchMoviesRoverUseCase(moviesRepository: MoviesRepository): SearchMoviesUseCase =
        SearchMoviesUseCase(moviesRepository)

    @Provides
    fun provideDeleteMovieUseCase(moviesRepository: MoviesRepository): DeleteMovieUseCase =
        DeleteMovieUseCase(moviesRepository)
}
