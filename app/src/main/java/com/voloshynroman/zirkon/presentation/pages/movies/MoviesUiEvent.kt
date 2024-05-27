package com.voloshynroman.zirkon.presentation.pages.movies

import com.voloshynroman.zirkon.core.common.UiEvent

/**
 * @author Roman Voloshyn (Created on 24.05.2024)
 */

sealed class MoviesUiEvent: UiEvent {
    data object LoadFilms : MoviesUiEvent()
}