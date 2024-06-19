package com.voloshynroman.zirkon.presentation.navigation

import kotlinx.serialization.Serializable


/**
 * @author Roman Voloshyn (Created on 17.05.2024)
 */

sealed class Routes {
    @Serializable
    data object SplashScreen: Routes()

    @Serializable
    data object SignInScreen: Routes()
    @Serializable
    data object SignUpScreen: Routes()

    @Serializable
    data object MainScreen: Routes()

    @Serializable
    data object MoviesScreen: Routes()
    @Serializable
    data object ProfileScreen: Routes()
    @Serializable
    data object Reviews: Routes()

    @Serializable
    data class MovieDetailsScreen(
        val movieId: Long
    ): Routes()
}