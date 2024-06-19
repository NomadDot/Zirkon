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
    val rating: Rating = Rating(),
    val description: String = emptyString(),
    val genres: List<Genre> = emptyList()
)
