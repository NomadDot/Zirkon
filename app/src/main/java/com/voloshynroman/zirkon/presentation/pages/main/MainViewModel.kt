package com.voloshynroman.zirkon.presentation.pages.main

import com.voloshynroman.zirkon.presentation.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import javax.inject.Inject

/**
 * @author Roman Voloshyn (Created on 19.05.2024)
 */

@HiltViewModel
class MainViewModel @Inject constructor(
): BaseViewModel<MainUiState, MainUiEvent>() {
    override fun handleUiEvent(uiEvent: MainUiEvent) {}

    fun fgjsdgn() {
        launch {
            val parallelJobs = listOf(
                async {

                },
                async {

                }
            ).awaitAll()
            (1..3).toList().parallelStream()
                .map {  }
        }
    }
}