package com.voloshynroman.zirkon.presentation.pages.movieDetails

import com.voloshynroman.zirkon.presentation.core.base.BaseViewModel
import com.voloshynroman.zirkon.domain.repositories.movie.IMovieDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Roman Voloshyn (Created on 28.05.2024)
 */

@HiltViewModel
class MovieDetailsVM @Inject constructor(
    private val movieDetailsRepository: IMovieDetailsRepository
): BaseViewModel<MovieDetailsState, MovieDetailsEvent>() {

    override fun handleUiEvent(uiEvent: MovieDetailsEvent) {
        when(uiEvent) {
            is MovieDetailsEvent.LoadDetails -> loadMovieDetails(uiEvent.movieId)
        }
    }

    private fun loadMovieDetails(movieId: Long) {
        launch {
            updateState {
                it.value = MovieDetailsState(isLoading = true)
            }

            movieDetailsRepository.fetchDetails(movieId)
               .collect { model ->
                    updateState {
                        it.value = MovieDetailsState(content = model)
                    }
                }
        }
    }
}