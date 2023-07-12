package com.mr_alhams.quickpizza.ui.screens.pizza_palette

import androidx.lifecycle.ViewModel
import com.mr_alhams.quickpizza.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PizzaPlateViewModel @Inject constructor() : ViewModel(), PizzaPlateInteractionListener {

    private val _uiState = MutableStateFlow(PizzaPlateUiState())
    val uiState = _uiState.asStateFlow()

    private val toppings = listOf(
        PizzaToppingsUiState(R.drawable.basil_1, false),
        PizzaToppingsUiState(R.drawable.borccoli_1, false),
        PizzaToppingsUiState(R.drawable.onion2, false),
        PizzaToppingsUiState(R.drawable.sausage_1, false),
        PizzaToppingsUiState(R.drawable.mushroom1, false),
    )

    init {
        getPizzaTypes()
        getPizzaSizes()
        getPizzaToppings()
    }

    private fun getPizzaTypes() {
        val pizzaTypes = listOf(
            PizzaUiState(R.drawable.bread1, 16, pizzaToppingsUiState = toppings),
            PizzaUiState(R.drawable.bread2, 17, pizzaToppingsUiState = toppings),
            PizzaUiState(R.drawable.bread3, 18, pizzaToppingsUiState = toppings),
            PizzaUiState(R.drawable.bread4, 19, pizzaToppingsUiState = toppings),
            PizzaUiState(R.drawable.bread5, 20, pizzaToppingsUiState = toppings),
        )

        _uiState.update { it.copy(pizzaTypes = pizzaTypes) }
    }

    private fun getPizzaSizes() {
        val pizzaSizes = listOf(
            PizzaSize.SMALL,
            PizzaSize.MEDIUM,
            PizzaSize.LARGE,
        )

        _uiState.update { it.copy(pizzaSizes = pizzaSizes) }
    }

    private fun getPizzaToppings() {

        val toppings = listOf(
            PizzaToppingsUiState(R.drawable.basil_1, false),
            PizzaToppingsUiState(R.drawable.borccoli_1, false),
            PizzaToppingsUiState(R.drawable.onion2, false),
            PizzaToppingsUiState(R.drawable.sausage_1, false),
            PizzaToppingsUiState(R.drawable.mushroom1, false),
        )

        _uiState.update { it.copy(pizzaToppings = toppings) }

    }

    override fun onClickPizzaSize(pizzaUiState: PizzaUiState, pizzaSize: PizzaSize) {

        val clickedPizzaIndex = _uiState.value.pizzaTypes.indexOf(pizzaUiState)

        val alteredPizzaUiState = pizzaUiState.copy(sizeType = pizzaSize)

        val alteredPizzaStateList = _uiState.value.pizzaTypes.toMutableList()

        alteredPizzaStateList[clickedPizzaIndex] = alteredPizzaUiState

        _uiState.update { it.copy(pizzaTypes = alteredPizzaStateList) }

    }

    override fun onClickPizzaTopping(
        pizzaUiState: PizzaUiState,
        toppingsUiState: PizzaToppingsUiState
    ) {
        val clickedPizzaIndex = _uiState.value.pizzaTypes.indexOf(pizzaUiState)

        val clickedToppingIndex =
            _uiState.value.pizzaTypes[clickedPizzaIndex]
                .pizzaToppingsUiState.indexOf(toppingsUiState)

        val alteredToppingsList =
            _uiState.value.pizzaTypes[clickedPizzaIndex].pizzaToppingsUiState.toMutableList()

        val selectionState = !toppingsUiState.isSelected

        alteredToppingsList[clickedToppingIndex] = toppingsUiState.copy(isSelected = selectionState)

        val alteredPizzaUiState = pizzaUiState.copy(pizzaToppingsUiState = alteredToppingsList)

        val alteredPizzaStateList = _uiState.value.pizzaTypes.toMutableList()

        alteredPizzaStateList.removeAt(clickedPizzaIndex)

        alteredPizzaStateList.add(clickedPizzaIndex, alteredPizzaUiState)

        _uiState.update { it.copy(pizzaTypes = alteredPizzaStateList) }
    }

}