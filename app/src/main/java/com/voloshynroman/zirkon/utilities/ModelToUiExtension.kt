package com.voloshynroman.zirkon.utilities

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.voloshynroman.zirkon.R
import com.voloshynroman.zirkon.domain.models.MovieDetailsModel
import com.voloshynroman.zirkon.domain.models.Rating
import com.voloshynroman.zirkon.presentation.pages.movieDetails.AdditionalInformation
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

/**
 * @author Roman Voloshyn (Created on 12.06.2024)
 */

val Rating.formattedRating: String get() = "$rawRating".take(3) + "/10 IMDb"

@Composable
fun MovieDetailsModel.getAdditionalInfo(): List<AdditionalInformation> {
    return listOf(
        AdditionalInformation(
            stringResource(id = R.string.length_of_film),
            length
        ),
        AdditionalInformation(
            stringResource(id = R.string.box_office),
            boxOffice
        )
    )
}

fun Long.formatRevenue(): String {
    val revenue = this.toString()
    return when {
        this > 100_000_000 -> StringBuilder(revenue)
            .apply {
                for (i in 3..7 step 4)
                    this.insert(i, " ")
            }.toString()
        this < 100_000_000 -> StringBuilder(revenue)
            .apply {
                for (i in 2..6 step 4)
                    this.insert(i, " ")
            }.toString()
        else -> revenue
    } + " $"
}

fun Long.convertMilliSecondsToDate(): String {
    val millis = TimeUnit.MINUTES.toMillis(this)
    val date = Date(millis)
    val format = SimpleDateFormat("H mm", Locale.ENGLISH)
    return StringBuilder(format.format(date)).apply {
        this.insert(1, "h")
    }.toString() + "m"
}