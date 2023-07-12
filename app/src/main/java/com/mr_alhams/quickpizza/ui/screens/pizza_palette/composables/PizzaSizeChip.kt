package com.mr_alhams.quickpizza.ui.screens.pizza_palette.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mr_alhams.quickpizza.ui.theme.labelMedium

@Composable
fun PizzaSizeChip(
    onClick: () -> Unit,
    sizeLabel: String,
    isSelected: Boolean
) {
    val shadowSpotColor = if (isSelected) Color.Black else Color.Transparent
    val shadowAmbientColor = if (isSelected) Color.Black else Color.Transparent

    Text(
        text = sizeLabel,
        style = labelMedium.copy(textAlign = TextAlign.Center),
        modifier = Modifier
            .shadow(
                8.dp,
                CircleShape,
                spotColor = shadowSpotColor,
                ambientColor = shadowAmbientColor
            )
            .clickable { onClick() }
            .background(Color.White, shape = CircleShape)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}