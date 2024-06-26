package com.voloshynroman.zirkon.presentation.pages.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.voloshynroman.zirkon.core.base.OnHandleEvent
import com.voloshynroman.zirkon.core.components.DefaultFloatButton
import com.voloshynroman.zirkon.core.components.ZirkonTopBar
import com.voloshynroman.zirkon.core.components.MainBottomNavBar
import com.voloshynroman.zirkon.presentation.navigation.Routes
import com.voloshynroman.zirkon.presentation.navigation.mainNavigation.MainNavigation
import com.voloshynroman.zirkon.presentation.theme.PrimaryContainerColor

/**
 * @author Roman Voloshyn (Created on 19.05.2024)
 */

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    MainContent(onHandleEvent = viewModel::handleUiEvent)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    onHandleEvent: OnHandleEvent<MainUiEvent>
) {
    val navController = rememberNavController()
    val isFloatingButtonShown = remember {
        mutableStateOf(true)
    }

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(color = PrimaryContainerColor),
        containerColor = PrimaryContainerColor,
        topBar = {
            ZirkonTopBar()
        },
        bottomBar = {
            MainBottomNavBar(navController = navController) {
                navController.navigate(it.route) {
                    restoreState = true
                }
                isFloatingButtonShown.value =
                    navController.currentDestination?.route == Routes.MoviesScreen.route
            }
        },
        floatingActionButton = {
            if(isFloatingButtonShown.value)
                DefaultFloatButton {}
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            MainNavigation(navController)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    MainContent {}
}

