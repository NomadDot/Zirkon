package com.voloshynroman.zirkon.domain.models

import com.voloshynroman.zirkon.utilities.emptyString

/**
 * @author Roman Voloshyn (Created on 03.06.2024)
 */

data class MovieDetailsModel(
    val title: String = emptyString(),
    val imagePath: String = emptyString(),
    val rating: Rating = Rating(),
    val genres: List<Genre> = emptyList(),
    val length: String = emptyString(),
    val language: String = emptyString(),
    val boxOffice: String = emptyString(),
    val description: String = emptyString()
)