package com.voloshynroman.zirkon.data.network.services.response

import com.google.gson.annotations.SerializedName
import com.voloshynroman.zirkon.domain.models.Genre

/**
 * @author Roman Voloshyn (Created on 27.05.2024)
 */

data class GenreResponse(
    @SerializedName("genres")
    val genres: List<Genre> = emptyList()
)