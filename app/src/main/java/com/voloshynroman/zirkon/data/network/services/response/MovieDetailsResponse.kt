package com.voloshynroman.zirkon.data.network.services.response
import com.google.gson.annotations.SerializedName
import com.voloshynroman.zirkon.domain.models.Genre
import com.voloshynroman.zirkon.domain.models.MovieDetailsModel
import com.voloshynroman.zirkon.domain.models.Rating
import com.voloshynroman.zirkon.utilities.convertMilliSecondsToDate
import com.voloshynroman.zirkon.utilities.emptyString
import com.voloshynroman.zirkon.utilities.formatRevenue


/**
 * @author Roman Voloshyn (Created on 03.06.2024)
 */

data class MovieDetailsReponse(
    @SerializedName("adult")
    val adult: Boolean = false,
    @SerializedName("backdrop_path")
    val backdropPath: String = emptyString(),
//    @SerializedName("belongs_to_collection")
//    val belongsToCollection: BelongsToCollection?,
    @SerializedName("budget")
    val budget: Int = 0,
    @SerializedName("genres")
    val genres: List<Genre> = emptyList(),
    @SerializedName("homepage")
    val homepage: String = emptyString(),
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("imdb_id")
    val imdbId: String = emptyString(),
    @SerializedName("origin_country")
    val originCountry: List<String> = emptyList(),
    @SerializedName("overview")
    val overview: String = emptyString(),
    @SerializedName("popularity")
    val popularity: Double = 0.0,
    @SerializedName("poster_path")
    val posterPath: String = emptyString(),
    @SerializedName("release_date")
    val releaseDate: String = emptyString(),
    @SerializedName("revenue")
    val revenue: Long = 0L,
    @SerializedName("runtime")
    val runtime: Long = 0L,
    @SerializedName("status")
    val status: String = emptyString(),
    @SerializedName("tagline")
    val tagline: String = emptyString(),
    @SerializedName("title")
    val title: String = emptyString(),
    @SerializedName("video")
    val video: Boolean = false,
    @SerializedName("vote_average")
    val rawRating: Double = 0.0,
    @SerializedName("vote_count")
    val voteCount: Int = 0
) {

    fun toMovieDetailsModel(): MovieDetailsModel {
        return MovieDetailsModel(
            title = title,
            rating = Rating(rawRating),
            genres = genres,
            length = runtime.convertMilliSecondsToDate(),
            language = originCountry.toString(),
            boxOffice = revenue.formatRevenue(),
            description = overview,
            imagePath = posterPath
        )
    }
}