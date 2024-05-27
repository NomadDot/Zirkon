package com.voloshynroman.zirkon.data.network.services

import com.voloshynroman.zirkon.data.network.services.response.DefaultFilmInfo
import com.voloshynroman.zirkon.data.network.services.response.GenreResponse
import com.voloshynroman.zirkon.data.network.services.response.Response
import retrofit2.http.GET

/**
 * @author Roman Voloshyn (Created on 19.05.2024)
 */

interface MovieListsService {
    @GET("movie/now_playing")
    suspend fun fetchNowPlayingFilms(): Response<List<DefaultFilmInfo>>

    @GET("genre/movie/list")
    suspend fun fetchAllGenres(): GenreResponse

    @GET("movie/popular")
    suspend fun fetchPopularFilms(): Response<List<DefaultFilmInfo>>
}