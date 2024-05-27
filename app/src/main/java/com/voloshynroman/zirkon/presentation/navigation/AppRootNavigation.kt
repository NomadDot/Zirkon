package com.voloshynroman.zirkon.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.voloshynroman.zirkon.presentation.pages.main.MainScreen
import com.voloshynroman.zirkon.presentation.pages.splash.SplashScreen

/**
 * @author Roman Voloshyn (Created on 19.05.2024)
 */

typealias Navigation = (String) -> Unit

@Composable
fun RootAppNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Routes.SplashScreen.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        val navigateTo: Navigation = { route ->
            navController.navigate(route)
        }

        composable(Routes.SplashScreen.route) {
            SplashScreen(navigateTo = navigateTo)
        }

        composable(Routes.MainScreen.route) {
            MainScreen(hiltViewModel())
        }
    }
}
