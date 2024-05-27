package com.voloshynroman.zirkon.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.voloshynroman.zirkon.presentation.navigation.RootAppNavigation
import com.voloshynroman.zirkon.presentation.theme.ZirkonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MainViewModel = hiltViewModel<MainViewModel>()

            LaunchedEffect(key1 = Unit) {
                viewModel.handleUiEvent(MainUiEvent.LoadGenres)
            }

            ZirkonTheme {
                RootAppNavigation()
            }
        }
    }
}
