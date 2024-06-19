package com.voloshynroman.zirkon.presentation.pages.main

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.voloshynroman.zirkon.presentation.core.base.OnHandleEvent
import com.voloshynroman.zirkon.presentation.core.components.DefaultFloatButton
import com.voloshynroman.zirkon.presentation.core.components.MainBottomNavBar
import com.voloshynroman.zirkon.presentation.core.components.ZirkonTopBar
import com.voloshynroman.zirkon.presentation.navigation.Routes
import com.voloshynroman.zirkon.presentation.navigation.mainNavigation.MainNavigation
import com.voloshynroman.zirkon.presentation.theme.PrimaryContainerColor

/**
 * @author Roman Voloshyn (Created on 19.05.2024)
 */

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onMovieDetailsNavigation: (Long) -> Unit
) {
    MainContent(onHandleEvent = viewModel::handleUiEvent, onMovieDetailsNavigation = onMovieDetailsNavigation)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    onHandleEvent: OnHandleEvent<MainUiEvent>,
    onMovieDetailsNavigation: (Long) -> Unit
) {
    val navController = rememberNavController()
    val isFloatingButtonShown = remember {
        mutableStateOf(true)
    }

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(color = LocalContentColor.current),
        containerColor = PrimaryContainerColor,
        topBar = {
            ZirkonTopBar()
        },
        bottomBar = {
            MainBottomNavBar(navController = navController) {
                navController.navigate(it.route) { restoreState = true }
                isFloatingButtonShown.value =
                    navController.currentDestination?.route?.substringAfterLast(".") == Routes.MoviesScreen.toString()
            }
        },
        floatingActionButton = {
            AnimatedVisibility(
                visible = isFloatingButtonShown.value,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                DefaultFloatButton {}
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).background(MaterialTheme.colorScheme.primaryContainer)) {
            MainNavigation(navController, onMovieDetailsNavigation = onMovieDetailsNavigation)
        }
    }
}

