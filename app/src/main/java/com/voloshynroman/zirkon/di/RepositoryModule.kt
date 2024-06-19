package com.voloshynroman.zirkon.di

import com.voloshynroman.zirkon.data.database.AppDatabase
import com.voloshynroman.zirkon.domain.repositories.ApiClient
import com.voloshynroman.zirkon.domain.repositories.genre.GenreRepository
import com.voloshynroman.zirkon.domain.repositories.genre.IGenreRepository
import com.voloshynroman.zirkon.domain.repositories.movie.IMovieDetailsRepository
import com.voloshynroman.zirkon.domain.repositories.movie.IMoviesRepository
import com.voloshynroman.zirkon.domain.repositories.movie.MovieDetailsRepository
import com.voloshynroman.zirkon.domain.repositories.movie.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * @author Roman Voloshyn (Created on 22.05.2024)
 */

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideMoviesRepository(api: ApiClient, genreRepository: IGenreRepository): IMoviesRepository =
        MoviesRepository(api, genreRepository)

    @Provides
    @ViewModelScoped
    fun provideGenreRepository(api: ApiClient, database: AppDatabase): IGenreRepository =
        GenreRepository(api, database)

    @Provides
    @ViewModelScoped
    fun provideMovieDetailsRepository(api: ApiClient): IMovieDetailsRepository =
        MovieDetailsRepository(api)
}