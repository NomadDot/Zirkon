package com.voloshynroman.zirkon.presentation.pages.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.voloshynroman.zirkon.domain.models.NowShowingFilm
import com.voloshynroman.zirkon.presentation.core.components.BigPosterImage
import com.voloshynroman.zirkon.presentation.core.components.PosterTitle
import com.voloshynroman.zirkon.presentation.core.components.Rating
import com.voloshynroman.zirkon.utilities.formattedRating

/**
 * @author Roman Voloshyn (Created on 19.05.2024)
 */

@Composable
fun NowShowingList(
    nowShowingFilms: List<NowShowingFilm>,
    modifier: Modifier = Modifier,
    onMovieClick: (Long) -> Unit
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentWidth()
            .background(color = MaterialTheme.colorScheme.primaryContainer),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(
            items = nowShowingFilms,
            key = { item -> item.id }
        ) {
            NowShowingFilmItem(
                model = it,
                isFirstItem = nowShowingFilms.first() == it,
                isLastItem = nowShowingFilms.last() == it,
                onMovieClick = onMovieClick::invoke
            )
        }
    }
}

@Composable
fun NowShowingFilmItem(
    model: NowShowingFilm,
    isFirstItem: Boolean,
    isLastItem: Boolean,
    modifier: Modifier = Modifier,
    onMovieClick: (Long) -> Unit
) {
    val firstItemPadding = if(isFirstItem) 24.dp else 0.dp
    val lastItemPadding = if(isLastItem) 24.dp else 0.dp

    Column(
        modifier = modifier
            .wrapContentWidth()
            .height(290.dp)
            .padding(start = firstItemPadding, end = lastItemPadding)
            .clickable { onMovieClick.invoke(model.id) },
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        BigPosterImage(imageUrl = model.posterUrl)
        Spacer(modifier = Modifier.height(12.dp))
        PosterTitle(title = model.title)
        Rating(
            rating = model.rating.formattedRating,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun NowShowingListPreview(modifier: Modifier = Modifier) {
    NowShowingList(
        listOf(
            NowShowingFilm(title = "kjls gfd dfg gdfs njkdf"),
            NowShowingFilm(title = "kjls gfd dfgnjkdf"),
            NowShowingFilm(title = "kjls gfd dfgnjkdf"),
            NowShowingFilm(title = "kjls gfd dfgnjkdf")
        ),
        modifier
    ) { }
}