package com.voloshynroman.zirkon.core.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.voloshynroman.zirkon.presentation.navigation.mainNavigation.MainBottomNavItem
import com.voloshynroman.zirkon.presentation.theme.AccentPrimary
import com.voloshynroman.zirkon.presentation.theme.PrimaryContainerColor
import com.voloshynroman.zirkon.presentation.theme.PurpleGrey80
import com.voloshynroman.zirkon.presentation.theme.TextColorTitle

/**
 * @author Roman Voloshyn (Created on 26.05.2024)
 */

@Composable
fun MainBottomNavBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    onNavigationButtonClick: ((MainBottomNavItem) -> Unit)? = null
) {
    NavigationBar(
        modifier = modifier
            .fillMaxWidth(),
        containerColor = PrimaryContainerColor
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        MainBottomNavItem.values.forEach { graph ->
            NavigationBarItem(
                colors = NavigationBarItemColors(
                    TextColorTitle, Color.Black, AccentPrimary,
                    PurpleGrey80, PurpleGrey80, Color.Gray,
                    PurpleGrey80
                ),
                icon = {
                    Icon(
                        imageVector = graph.icon,
                        contentDescription = null
                    )
                },
                selected = currentDestination?.hierarchy
                    ?.any { it.route == graph.route } == true,
                onClick =  {
                    onNavigationButtonClick?.invoke(graph)
                }
            )
        }
    }
}