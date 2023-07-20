package com.mr_alhams.quickpizza.ui.screens.pizza_palette.composables

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.mr_alhams.quickpizza.ui.theme.labelMedium

@Composable
fun PizzaSizeChip(
    onClick: () -> Unit,
    sizeLabel: String,
    isSelected: Boolean
) {

    Text(
        text = sizeLabel,
        style = labelMedium.copy(textAlign = TextAlign.Center),
        modifier = Modifier.clickable { onClick() }
    )

}