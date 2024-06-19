package com.voloshynroman.zirkon.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.voloshynroman.zirkon.presentation.pages.main.MainScreen
import com.voloshynroman.zirkon.presentation.pages.main.MainViewModel
import com.voloshynroman.zirkon.presentation.pages.movieDetails.MovieDetailsScreen
import com.voloshynroman.zirkon.presentation.pages.movieDetails.MovieDetailsVM
import com.voloshynroman.zirkon.presentation.pages.splash.SplashScreen
import kotlin.reflect.KClass

/**
 * @author Roman Voloshyn (Created on 19.05.2024)
 */

typealias Navigation = (Routes) -> Unit

@Composable
fun RootAppNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: KClass<Routes.SplashScreen> = Routes.SplashScreen::class
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        val navigateTo: Navigation = { route ->
            navController.navigate(route)
        }

        composable<Routes.SplashScreen> {
            SplashScreen(navigateTo = navigateTo)
        }

        composable<Routes.MovieDetailsScreen> {
            val args = it.toRoute<Routes.MovieDetailsScreen>()
            val viewModel = hiltViewModel<MovieDetailsVM>()

            MovieDetailsScreen(viewModel = viewModel, args.movieId) { navController.popBackStack() }
        }

        composable<Routes.MainScreen> {
            val viewModel = hiltViewModel<MainViewModel>()
            MainScreen(viewModel) {
                navController.navigate(Routes.MovieDetailsScreen(it))
            }
        }
    }
}