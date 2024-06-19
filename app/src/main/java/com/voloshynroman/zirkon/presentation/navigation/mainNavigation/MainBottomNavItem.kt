package com.voloshynroman.zirkon.presentation.navigation.mainNavigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.voloshynroman.zirkon.R
import com.voloshynroman.zirkon.presentation.navigation.Routes
import kotlin.reflect.KClass

/**
 * @author Roman Voloshyn (Created on 24.05.2024)
 */

sealed class MainBottomNavItem(
    val route: Routes, val icon: ImageVector, @StringRes val label: Int
) {
    data object Home : MainBottomNavItem(Routes.MoviesScreen, Icons.Default.Home, R.string.label_home)
    data object Reviews : MainBottomNavItem(Routes.Reviews, Icons.Default.Star, R.string.label_reviews)
    data object Profile : MainBottomNavItem(Routes.ProfileScreen, Icons.Default.Person, R.string.label_profile)

    companion object {
        val values = listOf(Home, Reviews, Profile)
    }
}