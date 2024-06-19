package com.voloshynroman.zirkon.presentation.pages.movieDetails

import com.voloshynroman.zirkon.utilities.emptyString

/**
 * @author Roman Voloshyn (Created on 14.06.2024)
 */

data class AdditionalInformation(
    val title: String = emptyString(),
    val value: String = emptyString()
)
