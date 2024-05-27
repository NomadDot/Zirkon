package com.voloshynroman.zirkon.presentation.pages.main

import com.voloshynroman.zirkon.core.common.UiEvent

/**
 * @author Roman Voloshyn (Created on 19.05.2024)
 */
sealed class MainUiEvent: UiEvent {
    data object LoadingLists: MainUiEvent()
}