package com.voloshynroman.zirkon.presentation.pages.main

import com.voloshynroman.zirkon.core.base.BaseViewModel
import com.voloshynroman.zirkon.core.common.Dialog
import com.voloshynroman.zirkon.core.common.Progress
import com.voloshynroman.zirkon.data.network.RestApi
import com.voloshynroman.zirkon.domain.repositories.movie.IMoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.zip
import javax.inject.Inject

/**
 * @author Roman Voloshyn (Created on 19.05.2024)
 */

@HiltViewModel
class MainViewModel @Inject constructor(
): BaseViewModel<MainUiState, MainUiEvent, Progress, Dialog>() {
    override fun handleUiEvent(uiEvent: MainUiEvent) {}
}