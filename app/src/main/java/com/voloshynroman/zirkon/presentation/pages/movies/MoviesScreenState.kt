package com.voloshynroman.zirkon.presentation.pages.movies

import com.voloshynroman.zirkon.presentation.core.common.UiState
import com.voloshynroman.zirkon.domain.models.NowShowingFilm
import com.voloshynroman.zirkon.domain.models.PopularFilm

/**
 * @author Roman Voloshyn (Created on 24.05.2024)
 */

data class MoviesScreenState(
    val nowShowingFilms: List<NowShowingFilm> = emptyList(),
    val popularFilms: List<PopularFilm> = emptyList(),
    val loading: Boolean = false
): UiState
