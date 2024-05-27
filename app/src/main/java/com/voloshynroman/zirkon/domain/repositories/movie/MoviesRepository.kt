package com.voloshynroman.zirkon.domain.repositories.movie

import com.voloshynroman.zirkon.data.network.services.MovieListsService
import com.voloshynroman.zirkon.domain.models.Genre
import com.voloshynroman.zirkon.domain.models.NowShowingFilm
import com.voloshynroman.zirkon.domain.models.PopularFilm
import com.voloshynroman.zirkon.domain.repositories.ApiClient
import com.voloshynroman.zirkon.domain.repositories.genre.IGenreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

/**
 * @author Roman Voloshyn (Created on 22.05.2024)
 */

interface IMoviesRepository {
    suspend fun fetchPopularFilms(): Flow<List<PopularFilm>>
    suspend fun fetchNowShowingFilms(): Flow<List<NowShowingFilm>>
}

class MoviesRepository(
    private val client: ApiClient,
    private val genreRepository: IGenreRepository
): IMoviesRepository {

    private fun getGenres(): Flow<List<Genre>> {
        return genreRepository.getGenresList()
    }

    private val movieService: MovieListsService by lazy {
        client.provideService(MovieListsService::class.java)
    }

    override suspend fun fetchNowShowingFilms(): Flow<List<NowShowingFilm>> =
        flow {
            emit(movieService.fetchNowPlayingFilms())
        }.map { response ->
            response.unwrapData()
                .map {
                    it.toNowShowingFilm()
                }
        }.flowOn(Dispatchers.IO)

    override suspend fun fetchPopularFilms(): Flow<List<PopularFilm>> =
        flow {
            getGenres().collect {
                emit(movieService.fetchNowPlayingFilms() to it)
            }
        }.map { pair ->
            val response = pair.first
            val genres = pair.second

            response.unwrapData()
                .map { it.toPopularFilm(genres) }
        }.flowOn(Dispatchers.IO)
}