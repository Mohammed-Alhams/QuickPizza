package com.mr_alhams.quickpizza.ui.screens.pizza_palette.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mr_alhams.quickpizza.ui.screens.pizza_palette.PizzaToppingsUiState
import com.mr_alhams.quickpizza.ui.theme.Green

@Composable
fun ChipPizzaTopping(
    onClick: () -> Unit,
    state: PizzaToppingsUiState,
) {
    val backgroundColor = if (state.isSelected) Green else Color.Transparent

    Image(
        painter = painterResource(id = state.image),
        contentDescription = null,
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .clickable { onClick() }
            .background(color = backgroundColor)
            .padding(8.dp)
    )
}