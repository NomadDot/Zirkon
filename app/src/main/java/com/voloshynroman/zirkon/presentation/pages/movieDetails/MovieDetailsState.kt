package com.voloshynroman.zirkon.presentation.pages.movieDetails

import com.voloshynroman.zirkon.presentation.core.common.UiState
import com.voloshynroman.zirkon.domain.models.MovieDetailsModel

/**
 * @author Roman Voloshyn (Created on 28.05.2024)
 */

data class MovieDetailsState(
    val content: MovieDetailsModel = MovieDetailsModel(),
    val isLoading: Boolean = false
): UiState