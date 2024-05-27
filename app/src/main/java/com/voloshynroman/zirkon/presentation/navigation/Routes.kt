package com.voloshynroman.zirkon.presentation.navigation

import com.voloshynroman.zirkon.utilities.emptyString

/**
 * @author Roman Voloshyn (Created on 17.05.2024)
 */

sealed class Routes(val route: String, val argument: String = emptyString()) {
    data object SplashScreen: Routes("splash")

    data object SignInScreen: Routes("signIn")
    data object SignUpScreen: Routes("signUp")

    data object MainScreen: Routes("main")

    data object MoviesScreen: Routes("movies")
    data object ProfileScreen: Routes("profile")
    data object Reviews: Routes("reviews")

    data object MovieDetailsScreen: Routes("movie/{id}")

}