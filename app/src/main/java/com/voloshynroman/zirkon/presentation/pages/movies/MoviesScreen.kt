package com.voloshynroman.zirkon.presentation.pages.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.voloshynroman.zirkon.R
import com.voloshynroman.zirkon.presentation.core.base.StateContentLayout
import com.voloshynroman.zirkon.presentation.core.components.CategoryTitle
import com.voloshynroman.zirkon.presentation.pages.main.components.NowShowingList
import com.voloshynroman.zirkon.presentation.pages.main.components.PopularFilmItem
import com.voloshynroman.zirkon.presentation.theme.PrimaryContainerColor

/**
 * @author Roman Voloshyn (Created on 24.05.2024)
 */

@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel,
    onMovieDetailsNavigation: (Long) -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.handleUiEvent(MoviesUiEvent.LoadFilms)
    }

    StateContentLayout(viewModel = viewModel) { state ->
        state?.let {
            MoviesScreenContent(moviesScreenState = it, onMovieDetailsNavigation)
        }
    }
}

@Composable
fun MoviesScreenContent(moviesScreenState: MoviesScreenState,
                        onMovieDetailsNavigation: (Long) -> Unit,
                        modifier: Modifier = Modifier,
) {
    if (moviesScreenState.loading)
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier
                    .width(35.dp)
                    .height(35.dp)
                    .align(Alignment.Center)
            )
        }
    else {
        LazyColumn(
            modifier = modifier
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .fillMaxSize()
        ) {
            item {
                CategoryTitle(
                    title = stringResource(R.string.now_showing),
                    additionalInfoTitle = stringResource(R.string.see_all),
                    modifier = Modifier.padding(horizontal = 24.dp)
                ) {}
            }
            item {
                NowShowingList(
                    modifier = Modifier.padding(top = 16.dp),
                    nowShowingFilms = moviesScreenState.nowShowingFilms,
                    onMovieClick = onMovieDetailsNavigation::invoke
                )
            }
            item {
                CategoryTitle(
                    title = stringResource(R.string.popular),
                    additionalInfoTitle =stringResource(R.string.see_all),
                    modifier = Modifier
                        .padding(top = 24.dp, bottom = 10.dp)
                        .padding(horizontal = 24.dp)
                ) {}
            }
            items(moviesScreenState.popularFilms, key = { item -> item.id }) {
                PopularFilmItem(
                    film = it,
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(top = 13.dp)
                )
            }
        }
    }
}