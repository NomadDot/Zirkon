package com.voloshynroman.zirkon.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.voloshynroman.zirkon.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)

val zirkonFonts = FontFamily(
    Font(R.font.merriweather_regular, FontWeight.Normal),
    Font(R.font.merriweather_black, FontWeight.Medium),
    Font(R.font.merriweather_bold, FontWeight.Bold)
)

val ZirkonTypography = Typography(
    titleMedium = TextStyle(
        fontFamily = zirkonFonts,
        fontWeight = FontWeight.Medium,
        color = TextColorTitle,
        fontSize = 14.sp,
        letterSpacing = 0.2.sp
    ),
    titleLarge = TextStyle(
        fontFamily = zirkonFonts,
        fontWeight = FontWeight.Bold,
        color = TextColorTitle,
        fontSize = 20.sp,
        letterSpacing = 0.2.sp
    ),
    bodySmall = TextStyle(
        fontFamily = zirkonFonts,
        fontWeight = FontWeight.Normal,
        color = TextColorSecondary,
        fontSize = 12.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = zirkonFonts,
        fontWeight = FontWeight.Normal,
        color = AccentPrimary,
        fontSize = 8.sp,
    ),
)