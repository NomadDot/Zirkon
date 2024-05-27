package com.voloshynroman.zirkon.core.base

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.voloshynroman.zirkon.core.common.Dialog
import com.voloshynroman.zirkon.core.common.Progress
import com.voloshynroman.zirkon.core.common.UiEvent
import com.voloshynroman.zirkon.core.common.UiState
import com.voloshynroman.zirkon.presentation.pages.main.MainUiEvent

/**
 * @author Roman Voloshyn (Created on 15.05.2024)
 */

typealias OnHandleEvent<T> = (T) -> Unit

@Composable
fun <S: UiState, E: UiEvent, P: Progress, D : Dialog> StateContentLayout(
    viewModel: BaseViewModel<S, E, P, D>,
    onBackPressed: (() -> Unit)? = null,
    content: @Composable (uiState: S?) -> Unit
) {
    BackHandler(
        enabled = onBackPressed != null,
        onBack = {
            onBackPressed?.invoke()
        }
    )

    val uiState by viewModel.uiState
    val eventState by viewModel.eventState

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        content(uiState)
    }
}