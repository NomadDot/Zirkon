package com.voloshynroman.zirkon.presentation.core.base

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.voloshynroman.zirkon.presentation.core.common.Dialog
import com.voloshynroman.zirkon.presentation.core.common.EventState
import com.voloshynroman.zirkon.presentation.core.common.Progress
import com.voloshynroman.zirkon.presentation.core.common.ProgressData
import com.voloshynroman.zirkon.presentation.core.common.UiEvent
import com.voloshynroman.zirkon.presentation.core.common.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Roman Voloshyn (Created on 15.05.2024)
 */

abstract class BaseViewModel<S: UiState, E: UiEvent> : ViewModel() {

    private var _uiState = mutableStateOf<S?>(null)
    val uiState: State<S?> = _uiState

/*    private var _eventState = mutableStateOf(EventState<P, D>())
    val eventState: State<EventState<P, D>> = _eventState*/

    protected fun updateState(block: (state: MutableState<S?>) -> Unit) {
        block.invoke(_uiState)
    }

    abstract fun handleUiEvent(uiEvent: E)

    protected fun launch(
        block: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch(context = Dispatchers.Main /*+ handler*/, block = block)

    /*protected fun launchWithProgress(
        progress: P? = null,
        block: suspend CoroutineScope.() -> Unit
    ) = launch {
        try {
            _eventState.value = _eventState.value.copy(progress = ProgressData(progress))
            block()
        } finally {
            _eventState.value = _eventState.value.copy(progress = null)
        }
    }
*/
}