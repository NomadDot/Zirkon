package com.voloshynroman.zirkon.presentation.activity

import com.voloshynroman.zirkon.presentation.core.common.UiEvent

/**
 * @author Roman Voloshyn (Created on 27.05.2024)
 */

sealed class MainUiEvent: UiEvent {
    data object LoadGenres: MainUiEvent()
}
