package com.voloshynroman.zirkon.presentation.pages.movieDetails

import com.voloshynroman.zirkon.presentation.core.common.UiEvent

/**
 * @author Roman Voloshyn (Created on 28.05.2024)
 */

sealed class MovieDetailsEvent: UiEvent {
    data class LoadDetails(val movieId: Long): MovieDetailsEvent()
}