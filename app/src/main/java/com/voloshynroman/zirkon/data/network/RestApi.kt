package com.voloshynroman.zirkon.data.network

import com.voloshynroman.zirkon.domain.repositories.ApiClient
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Roman Voloshyn (Created on 19.05.2024)
 */

private const val baseUrl = "https://api.themoviedb.org/3/"

class RestApi: ApiClient {
    companion object {
        val instance: RestApi = RestApi()
    }

    private var retrofit: Retrofit? = null
    private val apiServices = HashMap<Class<*>, Any?>()

    fun init(): Retrofit {
        return if(retrofit == null) {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(
                    Interceptor { chain ->
                        val request = chain.request().newBuilder()
                            .addHeader(AuthHeader, Bearer + Token)
                            .build()

                        val url = request.url
                            .newBuilder()
                            .addQueryParameter(Language, Localization_UA)
                            .build()

                        val localizedRequest = request.newBuilder().url(url).build()

                        chain.proceed(localizedRequest)
                    }
                ).build()

            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit!!
        } else
            retrofit!!
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T> createService(service: Class<T>): T {
        if (retrofit == null)
            throw ExceptionInInitializerError("Api not initialized. Please initialize API [RestApi.init()] before getting some service")
        return if (apiServices.containsKey(service))
            apiServices[service] as T
        else {
            val apiService = retrofit?.create(service)
            apiServices[service] = apiService
            apiService!!
        }
    }

    override fun <T> provideService(service: Class<T>): T {
        return createService(service)
    }
}