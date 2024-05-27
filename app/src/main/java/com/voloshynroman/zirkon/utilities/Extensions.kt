package com.voloshynroman.zirkon.utilities

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.UUID
import java.util.concurrent.Flow
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