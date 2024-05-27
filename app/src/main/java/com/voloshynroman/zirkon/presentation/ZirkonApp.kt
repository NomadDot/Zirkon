package com.voloshynroman.zirkon.presentation

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.util.DebugLogger
import com.voloshynroman.zirkon.data.network.RestApi
import dagger.hilt.android.HiltAndroidApp

/**
 * @author Roman Voloshyn (Created on 16.05.2024)
 */

@HiltAndroidApp
class ZirkonApp: Application(), ImageLoaderFactory {

    override fun onCreate() {
        super.onCreate()
        RestApi.instance.init()
    }

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .memoryCache {
                MemoryCache.Builder(this)
                    .maxSizePercent(0.20)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .directory(cacheDir.resolve("image_cache"))
                    .maxSizeBytes(5 * 1024 * 1024)
                    .build()
            }
            .logger(DebugLogger())
            .respectCacheHeaders(false)
            .build()
    }
}