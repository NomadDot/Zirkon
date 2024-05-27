package com.voloshynroman.zirkon.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.voloshynroman.zirkon.data.database.models.GenreEntity
import kotlinx.coroutines.flow.Flow

/**
 * @author Roman Voloshyn (Created on 27.05.2024)
 */

@Dao
interface GenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenres(genre: List<GenreEntity>)

    @Insert(GenreEntity::class, OnConflictStrategy.REPLACE)
    fun insertGenre(genre: GenreEntity)

    @Query("SELECT * FROM genres")
    fun getAllGenres(): Flow<List<GenreEntity>>
}