package com.voloshynroman.zirkon.domain.repositories.genre

import com.voloshynroman.zirkon.data.database.AppDatabase
import com.voloshynroman.zirkon.data.database.models.GenreEntity
import com.voloshynroman.zirkon.data.network.services.MovieListsService
import com.voloshynroman.zirkon.domain.models.Genre
import com.voloshynroman.zirkon.domain.repositories.ApiClient
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

/**
 * @author Roman Voloshyn (Created on 27.05.2024)
 */

interface IGenreRepository {
    suspend fun fetchGenres(): List<Genre>
    suspend fun saveGenresLocallyIfNeed()

    fun getGenresList(): Flow<List<Genre>>
}

class GenreRepository(
    private val api: ApiClient,
    private val database: AppDatabase
): IGenreRepository {

    private val movieService = api.provideService(MovieListsService::class.java)

    override suspend fun fetchGenres(): List<Genre> = withContext(IO) {
        val response = async {
            return@async movieService.fetchAllGenres().genres
        }
        return@withContext response.await()
    }

    override suspend fun saveGenresLocallyIfNeed() {
        withContext(IO) {
            database.genreDao()
                .getAllGenres()
                .collect {
                    if(it.isEmpty()) {
                        database.genreDao().insertGenres(
                            fetchGenres().map(Genre::toGenreEntity)
                        )
                    }
                }
        }
    }

    override fun getGenresList(): Flow<List<Genre>> =
        database.genreDao().getAllGenres()
            .map { it.map(GenreEntity::toGenre) }
            .flowOn(IO)
}