package com.voloshynroman.zirkon.domain.models

import com.google.gson.annotations.SerializedName
import com.voloshynroman.zirkon.data.database.models.GenreEntity
import com.voloshynroman.zirkon.utilities.emptyString
import com.voloshynroman.zirkon.utilities.randomId

/**
 * @author Roman Voloshyn (Created on 21.05.2024)
 */

data class Genre(
    val id: Long = randomId(),
    val name: String = emptyString()
) {
    fun toGenreEntity(): GenreEntity = GenreEntity(id, name)
}