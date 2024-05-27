package com.voloshynroman.zirkon.core.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.voloshynroman.zirkon.core.Constants

/**
 * @author Roman Voloshyn (Created on 22.05.2024)
 */

@Composable
fun BigPosterImage(imageUrl: String, modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier
            .width(145.dp)
            .height(215.dp),
        elevation = CardDefaults
            .cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        AsyncImage(
            model = Constants.ImageHostUrl + imageUrl,
            contentDescription = "Big film poster",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun SmallPosterImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(85.dp)
            .height(120.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        AsyncImage(
            model = Constants.ImageHostUrl + imageUrl,
            contentDescription = "Small film poster",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}