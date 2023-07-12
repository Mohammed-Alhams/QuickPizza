package com.mr_alhams.quickpizza.ui.screens.pizza_palette


data class PizzaPlateUiState(
    val pizzaTypes: List<PizzaUiState> = emptyList(),
    val pizzaSizes: List<PizzaSize> = emptyList(),
    val pizzaToppings: List<PizzaToppingsUiState> = emptyList(),
)

data class PizzaUiState(
    val image: Int = 0,
    val pizzaPrice: Int = 0,
    val sizeType: PizzaSize = PizzaSize.SMALL,
    val pizzaToppingsUiState: List<PizzaToppingsUiState> = emptyList(),
)

enum class PizzaSize(val letter: String) {
    SMALL("S"), MEDIUM("M"), LARGE("L")
}

data class PizzaToppingsUiState(
    val image: Int = 0,
    val isSelected: Boolean = false,
)