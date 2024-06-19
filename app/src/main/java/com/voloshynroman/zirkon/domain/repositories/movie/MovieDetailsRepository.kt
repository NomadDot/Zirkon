package com.voloshynroman.zirkon.domain.repositories.movie

import com.voloshynroman.zirkon.data.network.services.MovieDetailsService
import com.voloshynroman.zirkon.data.network.services.response.MovieDetailsReponse
import com.voloshynroman.zirkon.domain.models.MovieDetailsModel
import com.voloshynroman.zirkon.domain.repositories.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import okhttp3.Dispatcher

/**
 * @author Roman Voloshyn (Created on 03.06.2024)
 */

interface IMovieDetailsRepository {
    fun fetchDetails(movieId: Long): Flow<MovieDetailsModel>
}

class MovieDetailsRepository(
    private val apiClient: ApiClient
): IMovieDetailsRepository {

    private val movieService by lazy { apiClient.provideService(MovieDetailsService::class.java) }

    override fun fetchDetails(movieId: Long): Flow<MovieDetailsModel> {
        return flow { emit(movieService.fetchFilmDetails(movieId)) }
            .map(MovieDetailsReponse::toMovieDetailsModel)
            .flowOn(Dispatchers.IO)
    }
}

