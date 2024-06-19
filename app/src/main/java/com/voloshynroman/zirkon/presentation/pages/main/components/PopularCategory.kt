package com.voloshynroman.zirkon.presentation.pages.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.voloshynroman.zirkon.presentation.core.components.DurationText
import com.voloshynroman.zirkon.presentation.core.components.Genres
import com.voloshynroman.zirkon.presentation.core.components.PosterTitle
import com.voloshynroman.zirkon.presentation.core.components.Rating
import com.voloshynroman.zirkon.presentation.core.components.SmallPosterImage
import com.voloshynroman.zirkon.domain.models.Genre
import com.voloshynroman.zirkon.domain.models.PopularFilm
import com.voloshynroman.zirkon.presentation.core.components.PopularFilmTitle
import com.voloshynroman.zirkon.presentation.theme.PrimaryContainerColor
import com.voloshynroman.zirkon.presentation.theme.ZirkonTypography
import com.voloshynroman.zirkon.utilities.formattedRating

/**
 * @author Roman Voloshyn (Created on 22.05.2024)
 */

@Composable
fun PopularFilmItem(film: PopularFilm, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .height(120.dp)
    ) {
        SmallPosterImage(imageUrl = film.posterUrl)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            PopularFilmTitle(title = film.title)
            Rating(rating = film.rating.formattedRating, modifier = Modifier.padding(top = 10.dp))
            Text(
                text = film.description,
                maxLines = 2,
                style = ZirkonTypography.bodySmall,
                color = MaterialTheme.colorScheme.secondary,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 8.dp, end = 8.dp))
            Genres(model = film.genres, Modifier.padding(top = 8.dp))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun FilmItemPreview() {
    PopularFilmItem(
        film = PopularFilm(
            id = 32415,
            posterUrl = "",
            title = "Spiderman: Homecoming",
            rating = com.voloshynroman.zirkon.domain.models.Rating(4.656),
            genres = listOf(
                Genre(id = 7981, name = "Nicholson"),
                Genre(id = 7981, name = "Normand"),
                Genre(id = 7981, name = "Normandcholson"),
            ),
            description = "From an adventurous balloon ride above the clouds to a monster-filled metropolis, Academy Award®-winning director Pete Docter (“Monsters, Inc.,” “Up”) has"
        )
    )
}