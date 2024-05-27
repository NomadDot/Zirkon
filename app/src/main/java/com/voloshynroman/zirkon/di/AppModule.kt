package com.voloshynroman.zirkon.di

import android.content.Context
import com.voloshynroman.zirkon.data.database.AppDatabase
import com.voloshynroman.zirkon.data.network.RestApi
import com.voloshynroman.zirkon.domain.repositories.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Roman Voloshyn (Created on 22.05.2024)
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesMyApi(): ApiClient = RestApi.instance

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.getInstance(context)
}