package com.voloshynroman.zirkon.presentation.pages.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.voloshynroman.zirkon.core.components.DurationText
import com.voloshynroman.zirkon.core.components.Genres
import com.voloshynroman.zirkon.core.components.PosterTitle
import com.voloshynroman.zirkon.core.components.Rating
import com.voloshynroman.zirkon.core.components.SmallPosterImage
import com.voloshynroman.zirkon.domain.models.Genre
import com.voloshynroman.zirkon.domain.models.PopularFilm
import com.voloshynroman.zirkon.presentation.theme.PrimaryContainerColor

/**
 * @author Roman Voloshyn (Created on 22.05.2024)
 */

@Composable
fun PopularFilmItem(film: PopularFilm, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = PrimaryContainerColor)
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
            PosterTitle(title = film.title)
            Rating(
                rating = film.formattedRating,
                modifier = Modifier.padding(top = 10.dp)
            )
            Genres(model = film.genres, Modifier.padding(top = 8.dp))
            DurationText(text = film.formattedDuration, modifier = Modifier.padding(top = 8.dp))
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
            rating = 4.656,
            genres = listOf(
                Genre(id = 7981, name = "Nicholson"),
                Genre(id = 7981, name = "Normand"),
                Genre(id = 7981, name = "Normandcholson"),
            )
        )
    )
}