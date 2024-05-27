package com.voloshynroman.zirkon.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.voloshynroman.zirkon.R
import com.voloshynroman.zirkon.presentation.theme.ZirkonTypography
import com.voloshynroman.zirkon.utilities.emptyString

/**
 * @author Roman Voloshyn (Created on 22.05.2024)
 */

@Composable
fun CategoryTitle(
    title: String,
    additionalInfoTitle: String = emptyString(),
    modifier: Modifier = Modifier,
    onTitleAction: (() -> Unit)? = null) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = ZirkonTypography.titleLarge
        )
        onTitleAction?.let {
            CategoryButton(text = additionalInfoTitle, onClick = it)
        }
    }
}

@Composable
fun PosterTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        style = ZirkonTypography.titleMedium,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier.width(145.dp)
    )
}

@Composable
fun DurationText(text: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
    ) {
        Image(
            modifier = Modifier
                .width(10.dp)
                .height(10.dp)
                .align(Alignment.CenterVertically),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.ic_duration),
            contentDescription = "duration"
        )
        Text(
            text = text,
            style = ZirkonTypography.bodySmall,
            color = Color.Black,
        )
    }
}

 @Composable
 fun Rating(rating: String, modifier: Modifier = Modifier) {
     Row(
         horizontalArrangement = Arrangement.Center,
         modifier = modifier
     ) {
         Image(
             modifier = Modifier
                 .width(12.dp)
                 .height(12.dp)
                 .align(Alignment.CenterVertically),
             contentScale = ContentScale.Crop,
             painter = painterResource(id = R.drawable.ic_rating_star),
             contentDescription = "stars"
         )
         Text(
             text = "$rating/10 IMDb",
             style = ZirkonTypography.bodySmall,
             modifier = Modifier.padding(start = 4.dp)
         )
     }
 }

@Composable
fun TopBarTitle(title: String) {
    Text(
        text = title,
        style = ZirkonTypography.titleLarge
    )
}

@Preview()
@Composable
fun TitlePreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(30.dp),
        modifier = Modifier.background(Color.White)
    ) {
        CategoryTitle("Now showing", "See more") {}
        CategoryTitle("Popular", "See more") {}
        PosterTitle(title = "Spider man: Homecoming")
        Rating("5.4")
        DurationText(text = "1h 47m")
        TopBarTitle("Zirkon")
    }
}