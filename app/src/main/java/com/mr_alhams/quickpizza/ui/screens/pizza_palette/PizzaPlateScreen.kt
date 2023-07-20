package com.mr_alhams.quickpizza.ui.screens.pizza_palette

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mr_alhams.quickpizza.R
import com.mr_alhams.quickpizza.ui.screens.pizza_palette.composables.ChipPizzaTopping
import com.mr_alhams.quickpizza.ui.screens.pizza_palette.composables.PizzaBread
import com.mr_alhams.quickpizza.ui.screens.pizza_palette.composables.PizzaPlateSlider
import com.mr_alhams.quickpizza.ui.screens.pizza_palette.composables.PizzaToppings
import com.mr_alhams.quickpizza.ui.theme.labelLarge
import com.mr_alhams.quickpizza.ui.theme.labelMedium
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


@OptIn(ExperimentalFoundationApi::class)
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            setIcon(
                onClick = { }, modifier = Modifier.size(24.dp), imageResource = R.drawable.backk
            )

            Text(
                text = "Pizza",
                modifier = Modifier,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            setIcon(
                onClick = { },
                modifier = Modifier.size(24.dp),
                imageResource = R.drawable.heart
            )
        }

        PizzaPlateSlider(
            pagerState = pagerState,
            itemsCount = state.pizzaTypes.size,
            modifier = Modifier.padding(top = 36.dp),
        ) { currentIndex ->

            PizzaBread(state.pizzaTypes[currentIndex]) { pizzaSize ->
                state.pizzaTypes[currentIndex].pizzaToppingsUiState.forEach { pizzaToppingsUiState ->
                    PizzaToppings(pizzaToppingsUiState, pizzaSize, modifier = Modifier.matchParentSize())
                }
            }

        }

        Text(
            text = currentPizzaType.pizzaPrice.toString(),
            style = labelLarge,
            modifier = Modifier.padding(16.dp)
        )

        Box{

            val alignment by animateBackgroundAlignment(
                when (currentPizzaType.sizeType) {
                    PizzaSize.SMALL -> -1f
                    PizzaSize.MEDIUM -> 0f
                    PizzaSize.LARGE -> 1f
                }
            )

            Box(
                modifier = Modifier
                    .align(alignment)
                    .size(48.dp)
                    .shadow(
                        8.dp,
                        CircleShape,
                        spotColor = Color.Black,
                        ambientColor = Color.Black
                    )
                    .background(Color.White, shape = CircleShape)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {

                state.pizzaSizes.forEach { pizzaSize ->
                    Text(
                        text = pizzaSize.letter,
                        style = labelMedium.copy(textAlign = TextAlign.Center),
                        modifier = Modifier
                            .size(48.dp)
                            .clickable(interactionSource = MutableInteractionSource(), indication = null) {
                                listener.onClickPizzaSize(currentPizzaType, pizzaSize)
                            }
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
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

        IconButton(
            onClick = { },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 46.dp)
                .width(180.dp)
                .background(
                    Color(0xFF826644), RoundedCornerShape(16.dp)
                )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.size(28.dp),
                    painter = painterResource(id = R.drawable.cart),
                    tint = Color.White,
                    contentDescription = ""
                )
                Text(
                    text = "Add To Cart",
                    color = Color.White,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }


        }

    }
}

@Composable
fun animateBackgroundAlignment(targetValue: Float): State<BiasAlignment> {
    val horizontalBias by animateFloatAsState(
        targetValue = targetValue,
        animationSpec = tween(100),
        label = ""
    )
    return remember {
        derivedStateOf {
            BiasAlignment(
                horizontalBias = horizontalBias,
                verticalBias = 0f
            )
        }
    }
}

@Composable
fun setIcon(
    onClick: () -> Unit,
    modifier: Modifier,
    imageResource: Int
) {
    IconButton(onClick = { onClick() }) {
        Icon(modifier = modifier,painter = painterResource(imageResource), contentDescription = "")
    }
}