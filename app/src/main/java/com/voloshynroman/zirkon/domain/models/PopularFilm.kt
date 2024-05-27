package com.voloshynroman.zirkon.domain.models

import com.voloshynroman.zirkon.utilities.emptyString
import com.voloshynroman.zirkon.utilities.randomId

/**
 * @author Roman Voloshyn (Created on 21.05.2024)
 */

data class PopularFilm(
    val id: Long = randomId(),
    val posterUrl: String = emptyString(),
    val title: String = emptyString(),
    private val rating: Double = 0.0,
    val genres: List<Genre> = emptyList()
) {
    val formattedRating = rating.toString().take(3);
    val formattedDuration = "1h 46m"
}
