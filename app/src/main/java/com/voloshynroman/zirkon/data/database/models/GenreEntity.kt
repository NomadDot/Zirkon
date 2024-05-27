package com.voloshynroman.zirkon.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.voloshynroman.zirkon.domain.models.Genre
import com.voloshynroman.zirkon.utilities.emptyString

/**
 * @author Roman Voloshyn (Created on 27.05.2024)
 */

@Entity(tableName = "genres")
data class GenreEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo("name") val name: String = emptyString()
) {
    fun toGenre(): Genre = Genre(id, name)
}
