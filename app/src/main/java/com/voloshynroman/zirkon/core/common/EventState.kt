package com.voloshynroman.zirkon.core.common

/**
 * @author Roman Voloshyn (Created on 15.05.2024)
 */

open interface UiEvent

data class EventState<P : Progress, D : Dialog>(
    val progress: ProgressData<P>? = null,
    val dialog: D? = null
)
interface Progress
interface Dialog