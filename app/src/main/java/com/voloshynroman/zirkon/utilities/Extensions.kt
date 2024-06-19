package com.voloshynroman.zirkon.utilities

import androidx.compose.runtime.Composable
import com.voloshynroman.zirkon.presentation.core.ImageHostUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID
import java.util.concurrent.TimeUnit
import kotlin.random.Random

/**
 * @author Roman Voloshyn (Created on 17.05.2024)
 */

fun emptyString(): String = ""

fun randomStringId(): String = UUID.randomUUID().toString()
fun randomId(): Long = Random.nextInt().toLong()

@Composable
fun <T> List<T>?.letNotEmpty(
    action: @Composable (List<T>) -> Unit
) {
    this?.let {
        if(isNotEmpty()) action.invoke(this)
    }
}

suspend fun <T> flowableApi(request: () -> T) = flow<T> {
    emit(request.invoke())
}.flowOn(Dispatchers.IO)

fun String.toImageUrl(): String = ImageHostUrl + this