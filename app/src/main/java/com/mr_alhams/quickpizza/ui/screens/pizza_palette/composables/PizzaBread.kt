package com.mr_alhams.quickpizza.ui.screens.pizza_palette.composables

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mr_alhams.quickpizza.ui.screens.pizza_palette.PizzaSize
import com.mr_alhams.quickpizza.ui.screens.pizza_palette.PizzaUiState

@Composable
fun PizzaBread(
    currentPizzaType: PizzaUiState,
    modifier: Modifier = Modifier,
    toppingsContent: @Composable BoxScope.(size: Float) -> Unit,
) {
    val scale = when (currentPizzaType.sizeType) {
        PizzaSize.SMALL -> 1f
        PizzaSize.MEDIUM -> 1.1f
        PizzaSize.LARGE -> 1.2f
    }

    val pizzaSize by animateFloatAsState(targetValue = scale, label = "")

    Box {
        Image(
            painter = painterResource(id = currentPizzaType.image),
            contentDescription = null,
            modifier = modifier
                .size(220.dp)
                .scale(pizzaSize)
        )

        toppingsContent(scale)
    }
}