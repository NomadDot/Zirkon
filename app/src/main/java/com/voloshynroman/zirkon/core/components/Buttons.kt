package com.voloshynroman.zirkon.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.voloshynroman.zirkon.presentation.theme.SeeMoreStrokeColor
import com.voloshynroman.zirkon.presentation.theme.SeeMoreTextColor
import com.voloshynroman.zirkon.presentation.theme.AccentPrimary
import com.voloshynroman.zirkon.presentation.theme.TextColorTitle

/**
 * @author Roman Voloshyn (Created on 21.05.2024)
 */

@Composable
fun CategoryButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .border(1.dp, SeeMoreStrokeColor, CircleShape)
            .background(color = Color.White)
            .clickable { onClick?.invoke() }
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp),
            color = SeeMoreTextColor
        )
    }
}

@Composable
fun BackNavigationButton(
    modifier: Modifier = Modifier,
    onNavigationBack: (() -> Unit)? = null
) {
    IconButton(onClick = { onNavigationBack?.invoke() }, modifier = modifier) {
        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back button")
    }
}

@Composable
fun NavigationButton(
    modifier: Modifier = Modifier,
    navigationButtonModel: NavigationButtonModel
) {
    IconButton(
        onClick = { navigationButtonModel.onClick?.invoke() },
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(navigationButtonModel.icon),
            contentDescription = "Back button"
        )
    }
}

@Composable
fun DefaultFloatButton(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)
) {
    FloatingActionButton(
        onClick = onClick::invoke,
        containerColor = AccentPrimary,
        contentColor = TextColorTitle,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Rounded.Edit,
            contentDescription = "float button"
        )
    }
}

@Preview
@Composable
fun ButtonsPreview() {
    Column(
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        CategoryButton("See more")
        BackNavigationButton()
        DefaultFloatButton {}
    }
}