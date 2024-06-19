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
import com.voloshynroman.zirkon.presentation.pages.movies.MoviesViewModel
import kotlin.reflect.KClass

/**
 * @author Roman Voloshyn (Created on 24.05.2024)
 */

typealias Navigation = () -> Unit

@Composable
fun MainNavigation(
    navController: NavHostController,
    startDestination: KClass<Routes.MoviesScreen> = Routes.MoviesScreen::class,
    onMovieDetailsNavigation: (Long) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Routes.MoviesScreen> {
            val viewModel = hiltViewModel<MoviesViewModel>()

            MoviesScreen(viewModel = viewModel) { movieId ->
                onMovieDetailsNavigation.invoke(movieId)
            }
        }

        composable<Routes.Reviews> {
            Text(text = "Reviews screen", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
            // MoviesScreen(hiltViewModel())
        }

        composable<Routes.ProfileScreen> {
            Text(text = "Profile screen", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
             // MoviesScreen(hiltViewModel())
        }
    }
}