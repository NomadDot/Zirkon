package com.voloshynroman.zirkon.presentation.pages.movies

import com.voloshynroman.zirkon.core.base.BaseViewModel
import com.voloshynroman.zirkon.core.common.Dialog
import com.voloshynroman.zirkon.core.common.Progress
import com.voloshynroman.zirkon.domain.repositories.movie.IMoviesRepository
import com.voloshynroman.zirkon.presentation.pages.main.MainUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Roman Voloshyn (Created on 24.05.2024)
 */

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesRepository: IMoviesRepository
): BaseViewModel<MoviesScreenState, MoviesUiEvent, Progress, Dialog>() {

    override fun handleUiEvent(uiEvent: MoviesUiEvent) {
        when(uiEvent) {
            MoviesUiEvent.LoadFilms -> loadAllFilmCategories()
        }
    }

    private fun loadAllFilmCategories() {
        updateState {
            it.value = MoviesScreenState(loading = true)
        }

        launch {
            moviesRepository.fetchNowShowingFilms()
                .collect {
                    updateState { state ->
                        state.value = state.value?.copy(nowShowingFilms = it, loading = false)
                    }
                }
            moviesRepository.fetchPopularFilms()
                .collect {
                    updateState { state ->
                        state.value = state.value?.copy(popularFilms = it, loading = false)
                    }
                }
        }
    }

}
