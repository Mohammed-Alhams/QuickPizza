package com.mr_alhams.quickpizza.ui.screens.pizza_palette.composables

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mr_alhams.quickpizza.ui.screens.pizza_palette.PizzaSize
import com.mr_alhams.quickpizza.ui.screens.pizza_palette.PizzaUiState

@Composable
fun PizzaBread(
    currentPizzaType: PizzaUiState,
    modifier: Modifier = Modifier,
    toppingsContent: @Composable (size: Int) -> Unit,
) {
    val size = when (currentPizzaType.sizeType) {
        PizzaSize.SMALL -> 220
        PizzaSize.MEDIUM -> 240
        PizzaSize.LARGE -> 260
    }

    val pizzaSize by animateDpAsState(targetValue = size.dp, label = "")

    Box {
        Image(
            painter = painterResource(id = currentPizzaType.image),
            contentDescription = null,
            modifier = modifier
                .size(pizzaSize)
        )

        toppingsContent(size)
    }
}