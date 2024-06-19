package com.voloshynroman.zirkon.presentation.pages.movieDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.voloshynroman.zirkon.R
import com.voloshynroman.zirkon.domain.models.Genre
import com.voloshynroman.zirkon.domain.models.MovieDetailsModel
import com.voloshynroman.zirkon.domain.models.Rating
import com.voloshynroman.zirkon.presentation.core.base.StateContentLayout
import com.voloshynroman.zirkon.presentation.core.components.BigPosterTitle
import com.voloshynroman.zirkon.presentation.core.components.DescriptionText
import com.voloshynroman.zirkon.presentation.core.components.Genres
import com.voloshynroman.zirkon.presentation.core.components.PosterTitle
import com.voloshynroman.zirkon.presentation.core.components.Rating
import com.voloshynroman.zirkon.presentation.core.components.TransparentTopAppBar
import com.voloshynroman.zirkon.presentation.theme.TextPrimaryColor
import com.voloshynroman.zirkon.presentation.theme.ZirkonTypography
import com.voloshynroman.zirkon.utilities.formattedRating
import com.voloshynroman.zirkon.utilities.getAdditionalInfo
import com.voloshynroman.zirkon.utilities.toImageUrl

/**
 * @author Roman Voloshyn (Created on 28.05.2024)
 */

@Composable
fun MovieDetailsScreen(
    viewModel: MovieDetailsVM,
    movieId: Long = 0,
    onBackNavigation: (() -> Unit)? = null
) {
    StateContentLayout(
        viewModel = viewModel,
        launchedEffect = {
            viewModel.handleUiEvent(MovieDetailsEvent.LoadDetails(movieId))
        }
    ) { state ->
        state?.let {
            if(it.isLoading) Loader()
            else MovieDetailsContent(content = it.content, onBackNavigation = onBackNavigation)
        }
    }
}

@Composable
fun Loader(modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
    ) {
        CircularProgressIndicator(
            modifier = modifier
                .height(50.dp)
                .width(50.dp)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun MovieDetailsContent(content: MovieDetailsModel, modifier: Modifier = Modifier, onBackNavigation: (() -> Unit)? = null) {
    Box(modifier = modifier
        .fillMaxSize()
    ) {
        BackgroundImage(content.imagePath, Modifier.align(Alignment.TopCenter))
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 300.dp)
                .align(Alignment.BottomCenter)
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
                .padding(horizontal = 24.dp)
                .padding(top = 24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            BigPosterTitle(title = content.title, modifier = Modifier.fillMaxWidth())
            Rating(rating = content.rating.formattedRating, modifier = Modifier.padding(top = 8.dp))
            Genres(model = content.genres, modifier = Modifier.padding(top = 16.dp))
            InformationRow(info = content.getAdditionalInfo(), modifier = Modifier.padding(top = 16.dp))
            PosterTitle(title = stringResource(id = R.string.description), modifier = Modifier.padding(top = 24.dp))
            DescriptionText(description = content.description, modifier = Modifier.padding(top = 8.dp))
        }
        TransparentTopAppBar(modifier = Modifier.fillMaxWidth()
            .align(Alignment.TopStart)
            .padding(top = 8.dp)
        ) { onBackNavigation?.invoke() }
    }
}

@Composable
private fun BackgroundImage(url: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = url.toImageUrl(),
        contentDescription = "",
        contentScale = ContentScale.FillBounds,
        modifier = modifier
            .fillMaxWidth()
            .height(400.dp)
            .background(color = Color.Black)
    )
}

@Composable
fun InformationRow(info: List<AdditionalInformation>, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        info.forEach {
            InfoText(title = it.title, value = it.value)
        }
    }
}

@Composable
fun InfoText(title: String, value: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = title, style = ZirkonTypography.bodySmall, color = MaterialTheme.colorScheme.scrim,)
        Text(text = value,
            style = ZirkonTypography.labelSmall,
            color = MaterialTheme.colorScheme.scrim,
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}

@Preview(showSystemUi = true)
@Composable
fun MovieDetailsPreview(modifier: Modifier = Modifier) {
    MovieDetailsContent(content = MovieDetailsModel(
        title = "Spiderman: No Way Home",
        imagePath = "sed",
        rating = Rating(8.1),
        genres = listOf(Genre(name = "Action"), Genre(name = "Fantasy"), Genre(name = "Adventure")),
        length = "1h 22m",
        language = "English",
        boxOffice = "241 000 000 $",
        description = "qui fjsdanbfj ksndf fjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndf fjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndffjsdanbfj ksndf fjsdanbfj ksndfsque"
    ))
}