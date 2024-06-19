package com.voloshynroman.zirkon.presentation.activity

import androidx.lifecycle.viewModelScope
import com.voloshynroman.zirkon.presentation.core.base.BaseViewModel
import com.voloshynroman.zirkon.presentation.core.common.Dialog
import com.voloshynroman.zirkon.presentation.core.common.Progress
import com.voloshynroman.zirkon.presentation.core.common.UiState
import com.voloshynroman.zirkon.domain.repositories.genre.IGenreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Roman Voloshyn (Created on 27.05.2024)
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val genreRepository: IGenreRepository
): BaseViewModel<UiState, MainUiEvent>() {
    override fun handleUiEvent(uiEvent: MainUiEvent) {
        when(uiEvent) {
            MainUiEvent.LoadGenres -> loadGenres()
        }
    }

    private fun loadGenres() {
        viewModelScope.launch(Dispatchers.Main) {
            genreRepository.saveGenresLocallyIfNeed()
        }
    }
}