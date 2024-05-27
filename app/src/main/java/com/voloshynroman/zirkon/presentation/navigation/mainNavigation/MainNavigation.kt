package com.voloshynroman.zirkon.presentation.navigation.mainNavigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.voloshynroman.zirkon.presentation.navigation.Routes
import com.voloshynroman.zirkon.presentation.pages.movies.MoviesScreen

/**
 * @author Roman Voloshyn (Created on 24.05.2024)
 */

typealias Navigation = (String) -> Unit

@Composable
fun MainNavigation(
    navController: NavHostController,
    startDestination: String = Routes.MoviesScreen.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Routes.MoviesScreen.route) {
            MoviesScreen(hiltViewModel())
        }

        composable(Routes.Reviews.route) {
            Text(text = "Reviews screen", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
            // MoviesScreen(hiltViewModel())
        }

        composable(Routes.ProfileScreen.route) {
            Text(text = "Profile screen", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
             // MoviesScreen(hiltViewModel())
        }
    }
}