package com.mr_alhams.quickpizza.ui.screens.pizza_palette

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mr_alhams.quickpizza.R
import com.mr_alhams.quickpizza.ui.screens.pizza_palette.composables.ChipPizzaTopping
import com.mr_alhams.quickpizza.ui.screens.pizza_palette.composables.PizzaBread
import com.mr_alhams.quickpizza.ui.screens.pizza_palette.composables.PizzaPlateSlider
import com.mr_alhams.quickpizza.ui.screens.pizza_palette.composables.PizzaSizeChip
import com.mr_alhams.quickpizza.ui.screens.pizza_palette.composables.PizzaToppings
import com.mr_alhams.quickpizza.ui.theme.labelLarge
import com.mr_alhams.quickpizza.ui.theme.titleSmall


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaPlateScreen(
    viewModel: PizzaPlateViewModel = hiltViewModel()
) {

    val pagerState = rememberPagerState()

    val state by viewModel.uiState.collectAsState()

    PizzaPlateContent(pagerState, state, viewModel)

}


@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun PizzaPlateContent(
    pagerState: PagerState,
    state: PizzaPlateUiState,
    listener: PizzaPlateInteractionListener
) {

    val currentPizzaType = state.pizzaTypes[pagerState.currentPage]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        PizzaPlateSlider(
            pagerState = pagerState,
            itemsCount = state.pizzaTypes.size,
            modifier = Modifier.padding(top = 36.dp),
        ) { currentIndex ->

            PizzaBread(state.pizzaTypes[currentIndex]) { pizzaSize ->
                state.pizzaTypes[currentIndex].pizzaToppingsUiState.forEach { pizzaToppingsUiState ->
                    PizzaToppings(pizzaToppingsUiState, pizzaSize)
                }
            }

        }

        Text(
            text = currentPizzaType.pizzaPrice.toString(),
            style = labelLarge,
            modifier = Modifier.padding(16.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(top = 24.dp)
        ) {
            state.pizzaSizes.forEach {
                PizzaSizeChip(
                    onClick = { listener.onClickPizzaSize(currentPizzaType, it) },
                    it.letter,
                    currentPizzaType.sizeType == it
                )
            }
        }


        Text(
            text = stringResource(R.string.customize_your_pizza),
            style = titleSmall.copy(color = Color.Gray),
            modifier = Modifier
                .padding(top = 36.dp, start = 16.dp)
                .align(Alignment.Start),
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            items(currentPizzaType.pizzaToppingsUiState) {
                ChipPizzaTopping(
                    onClick = { listener.onClickPizzaTopping(currentPizzaType, it) }, it
                )
            }
        }

    }
}