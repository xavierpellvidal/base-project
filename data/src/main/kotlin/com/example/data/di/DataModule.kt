package com.example.data.di

import com.example.core.api.service.MovieApi
import com.example.core.database.dao.MovieDao
import com.example.data.datasource.MoviesApiDataSource
import com.example.data.datasource.MoviesDatabaseDataSource
import com.example.data.datasource.MoviesLocalDataSource
import com.example.data.datasource.MoviesRemoteDataSource
import com.example.data.repository.MoviesRepositoryImpl
import com.example.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideMoviesLocalDataSource(movieDao: MovieDao): MoviesLocalDataSource = MoviesDatabaseDataSource(movieDao)

    @Provides
    @Singleton
    fun provideMoviesRemoteDataSource(movieApi: MovieApi): MoviesRemoteDataSource = MoviesApiDataSource(movieApi)

    @Provides
    fun provideMoviesRepository(
        moviesRemoteDataSource: MoviesRemoteDataSource,
        moviesLocalDataSource: MoviesLocalDataSource,
    ): MoviesRepository =
        MoviesRepositoryImpl(
            moviesRemoteDataSource = moviesRemoteDataSource,
            moviesLocalDataSource = moviesLocalDataSource,
        )
}
