package com.voloshynroman.zirkon.data.network.services

import com.voloshynroman.zirkon.data.network.services.response.MovieDetailsReponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Roman Voloshyn (Created on 03.06.2024)
 */

interface MovieDetailsService {
    @GET("movie/{movie_id}")
    suspend fun fetchFilmDetails(@Path("movie_id") movieId: Long): MovieDetailsReponse
}