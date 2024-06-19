package com.voloshynroman.zirkon.data.network.services.response

import com.google.gson.annotations.SerializedName
import com.voloshynroman.zirkon.presentation.core.components.Genres
import com.voloshynroman.zirkon.domain.models.Genre
import com.voloshynroman.zirkon.domain.models.NowShowingFilm
import com.voloshynroman.zirkon.domain.models.PopularFilm
import com.voloshynroman.zirkon.domain.models.Rating
import com.voloshynroman.zirkon.utilities.emptyString
import kotlin.random.Random

/**
 * @author Roman Voloshyn (Created on 19.05.2024)
 */

data class DefaultFilmInfo(
    @SerializedName("genre_ids")
    val genreIds: List<Long?>?,
    @SerializedName("id")
    val id: Long?,
    @SerializedName("overview")
    val overview: String = emptyString(),
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("vote_count")
    val voteCount: Int?
) {
    fun toNowShowingFilm(): NowShowingFilm =
        NowShowingFilm(
            id = this.id ?: Random.nextLong(),
            posterUrl = posterPath ?: emptyString(),
            title = title ?: emptyString(),
            rating = Rating(voteAverage ?: 0.0)
        )

    fun toPopularFilm(inGenres: List<Genre> = emptyList()): PopularFilm =
        PopularFilm(
            id = this.id ?: Random.nextLong(),
            posterUrl = posterPath ?: emptyString(),
            title = title ?: emptyString(),
            rating = Rating(voteAverage ?: 0.0),
            genres = convertGenre(inGenres),
            description = overview
        )

    private fun convertGenre(inGenres: List<Genre>): List<Genre> {
        return inGenres.filter { genre -> genreIds?.contains(genre.id) == true }
    }
}