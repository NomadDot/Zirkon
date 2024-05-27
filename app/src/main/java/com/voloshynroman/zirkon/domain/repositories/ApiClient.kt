package com.voloshynroman.zirkon.domain.repositories

/**
 * @author Roman Voloshyn (Created on 22.05.2024)
 */

interface ApiClient {
    fun <T> provideService(service: Class<T>): T
}