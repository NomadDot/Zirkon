package com.voloshynroman.zirkon.domain.models

import com.voloshynroman.zirkon.utilities.emptyString
import com.voloshynroman.zirkon.utilities.randomId
import com.voloshynroman.zirkon.utilities.randomStringId

/**
 * @author Roman Voloshyn (Created on 19.05.2024)
 */

data class NowShowingFilm(
    val id: Long = randomId(),
    val posterUrl: String = emptyString(),
    val title: String = emptyString(),
    val rating: Rating = Rating()
)