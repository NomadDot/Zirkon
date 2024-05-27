package com.voloshynroman.zirkon.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.voloshynroman.zirkon.data.database.dao.GenreDao
import com.voloshynroman.zirkon.data.database.models.GenreEntity

/**
 * @author Roman Voloshyn (Created on 27.05.2024)
 */

@Database(
    version = 1,
    entities = [
        GenreEntity::class
    ]
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun genreDao(): GenreDao

    companion object {
        private var databaseInstance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if(databaseInstance == null)
                databaseInstance = Room
                    .databaseBuilder(context, AppDatabase::class.java, "zirkon_db")
                    .build()

            return databaseInstance as AppDatabase
        }
    }
}