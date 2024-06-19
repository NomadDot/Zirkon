package com.voloshynroman.zirkon.presentation.pages.main

import com.voloshynroman.zirkon.presentation.core.common.UiEvent

/**
 * @author Roman Voloshyn (Created on 19.05.2024)
 */
sealed class MainUiEvent: UiEvent {
    data object LoadingLists: MainUiEvent()
}