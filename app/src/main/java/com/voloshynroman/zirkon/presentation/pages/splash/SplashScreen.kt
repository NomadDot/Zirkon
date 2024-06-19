package com.voloshynroman.zirkon.presentation.pages.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.voloshynroman.zirkon.R
import com.voloshynroman.zirkon.presentation.navigation.Navigation
import com.voloshynroman.zirkon.presentation.navigation.Routes
import com.voloshynroman.zirkon.presentation.theme.PrimaryContainerColor
import com.voloshynroman.zirkon.presentation.theme.TextColorTitle
import kotlinx.coroutines.delay

/**
 * @author Roman Voloshyn (Created on 19.05.2024)
 */

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navigateTo: Navigation = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = PrimaryContainerColor),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher),
            contentDescription = "logo",
            modifier = Modifier.fillMaxWidth(),
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Zirkon",
            color = TextColorTitle,
            fontSize = 27.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            textAlign = TextAlign.Center
        )

        LaunchedEffect(key1 = Unit) {
            delay(500)
            navigateTo.invoke(Routes.MainScreen)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SplashScreenPreview(modifier: Modifier = Modifier) {
    SplashScreen(modifier)
}