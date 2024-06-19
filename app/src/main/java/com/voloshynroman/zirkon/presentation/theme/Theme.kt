package com.voloshynroman.zirkon.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    primary = DarkAccentColor,
    secondary = DarkSecondaryColor,
    tertiary = DarkTextAccent,
    primaryContainer = DarkContainerColor,
    background = DarkAccentBackgroundColor,
    scrim = DarkSecondaryColor
)

private val LightColorScheme = lightColorScheme(
    primary = TextColorTitle,
    secondary = TextColorSecondary,
    tertiary = LightTextAccent,
    primaryContainer = PrimaryContainerColor,
    background = LightAccentBackgroundColor,
    scrim = TextColorTitle

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun ZirkonTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    fun showSystemStatusBar(color: Color) {
        systemUiController.setSystemBarsColor(color = color)
    }

    val colorScheme = when {
        darkTheme -> {
            showSystemStatusBar(DarkPrimaryColor)
            DarkColorScheme
        }
        else -> {
            showSystemStatusBar(PrimaryContainerColor)
            LightColorScheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = ZirkonTypography,
        content = content
    )
}