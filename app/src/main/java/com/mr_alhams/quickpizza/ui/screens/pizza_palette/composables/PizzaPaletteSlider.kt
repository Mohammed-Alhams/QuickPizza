package com.mr_alhams.quickpizza.ui.screens.pizza_palette.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mr_alhams.quickpizza.R

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun PizzaPlateSlider(
    pagerState: PagerState,
    itemsCount: Int,
    modifier: Modifier = Modifier,
    content: @Composable (index: Int) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.plate),
            contentDescription = null,
            modifier = Modifier.size(300.dp)
        )

        HorizontalPager(
            state = pagerState,
            pageCount = itemsCount,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            content(it)
        }
    }
}