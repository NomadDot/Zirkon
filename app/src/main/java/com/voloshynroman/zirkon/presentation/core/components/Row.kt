package com.voloshynroman.zirkon.presentation.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.voloshynroman.zirkon.domain.models.Genre
import com.voloshynroman.zirkon.presentation.theme.ZirkonTypography

/**
 * @author Roman Voloshyn (Created on 22.05.2024)
 */

@Composable
fun GenreItem(model: Genre, modifier: Modifier = Modifier, onClick: (() -> Unit)? = null) {
    Box(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .background(color = MaterialTheme.colorScheme.background, CircleShape)
            .clickable { onClick?.invoke() }
    ) {
        Text(
            text = model.name,
            style = ZirkonTypography.headlineSmall,
            color = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
        )
    }
}

@Composable
fun Genres(model: List<Genre>, modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(model) {
            GenreItem(it)
        }
    }
}

@Preview
@Composable
fun Preview() {
    Genres(model = listOf(
        Genre(id = 7981, name = "Nicholson"),
        Genre(id = 7981, name = "Normand"),
        Genre(id = 7981, name = "Normandcholson"),
    ))
}