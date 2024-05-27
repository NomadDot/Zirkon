@file:OptIn(ExperimentalMaterial3Api::class)

package com.voloshynroman.zirkon.core.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.voloshynroman.zirkon.R
import com.voloshynroman.zirkon.presentation.theme.PrimaryContainerColor
import com.voloshynroman.zirkon.presentation.theme.TextColorTitle
import kotlin.random.Random

/**
 * @author Roman Voloshyn (Created on 24.05.2024)
 */

data class NavigationButtonModel(
    @DrawableRes val icon: Int = Random.nextInt(),
    val isBack: Boolean = false,
    val onClick: (() -> Unit)? = null
)

@Composable
fun ZirkonTopBar(
    title: String = stringResource(id = R.string.app_name),
    navigationButton: NavigationButtonModel? = null,
    vararg additionalActions: NavigationButtonModel = emptyArray()
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = PrimaryContainerColor,
            titleContentColor = TextColorTitle,
        ),
        title = { TopBarTitle(title) },
        navigationIcon = {
            navigationButton?.let {
                if(it.isBack)
                    BackNavigationButton(onNavigationBack = {
                        navigationButton.onClick?.invoke()
                    })
                else
                    NavigationButton(navigationButtonModel = it)
            }
        },
        actions = {
            additionalActions.forEach {
                IconButton(onClick = { it.onClick?.invoke() }) {
                    Image(painter = painterResource(id = it.icon), contentDescription = "...")
                }
            }
        }
    )
}