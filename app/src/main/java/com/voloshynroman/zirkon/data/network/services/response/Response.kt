package com.voloshynroman.zirkon.data.network.services.response

import com.google.gson.annotations.SerializedName

/**
 * @author Roman Voloshyn (Created on 22.05.2024)
 */

data class Response<T>(
    @SerializedName("results")
    private val results: T
) {
    fun unwrapData(): T = results
}
