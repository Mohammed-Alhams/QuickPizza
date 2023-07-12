package com.mr_alhams.quickpizza.ui.screens.pizza_palette

interface PizzaPlateInteractionListener {

    fun onClickPizzaSize(
        pizzaUiState: PizzaUiState,
        pizzaSize: PizzaSize
    )

    fun onClickPizzaTopping(
        pizzaUiState: PizzaUiState,
        toppingsUiState: PizzaToppingsUiState
    )

}