package com.mr_alhams.quickpizza.ui.screens.pizza_palette

import androidx.lifecycle.ViewModel
import com.mr_alhams.quickpizza.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class PizzaPlateViewModel @Inject constructor() : ViewModel(), PizzaPlateInteractionListener {

    private val _uiState = MutableStateFlow(PizzaPlateUiState())
    val uiState = _uiState.asStateFlow()

    private val basil = listOf(
        R.drawable.basil_1,
        R.drawable.basil_2,
        R.drawable.basil_3,
        R.drawable.basil_4,
        R.drawable.basil_5,
        R.drawable.basil_6,
        R.drawable.basil_7,
        R.drawable.basil_8,
        R.drawable.basil_9,
        R.drawable.basil_10,
        R.drawable.basil_1,
        R.drawable.basil_2,
        R.drawable.basil_3,
        R.drawable.basil_4,
        R.drawable.basil_5,
        R.drawable.basil_6,
        R.drawable.basil_7,
        R.drawable.basil_8,
        R.drawable.basil_9,
        R.drawable.basil_10,
    )

    private val onion = listOf(
        R.drawable.onion1,
        R.drawable.onion2,
        R.drawable.onion3,
        R.drawable.onion4,
        R.drawable.onion5,
        R.drawable.onion6,
        R.drawable.onion7,
        R.drawable.onion8,
        R.drawable.onion9,
        R.drawable.onion10,
        R.drawable.onion1,
        R.drawable.onion2,
        R.drawable.onion3,
        R.drawable.onion4,
        R.drawable.onion5,
        R.drawable.onion6,
        R.drawable.onion7,
        R.drawable.onion8,
        R.drawable.onion9,
        R.drawable.onion10,
    )

    private val mushroom = listOf(
        R.drawable.mushroom1,
        R.drawable.mushroom2,
        R.drawable.mushroom3,
        R.drawable.mushroom4,
        R.drawable.mushroom5,
        R.drawable.mushroom6,
        R.drawable.mushroom7,
        R.drawable.mushroom8,
        R.drawable.mushroom9,
        R.drawable.mushroom10,
        R.drawable.mushroom1,
        R.drawable.mushroom2,
        R.drawable.mushroom3,
        R.drawable.mushroom4,
        R.drawable.mushroom5,
        R.drawable.mushroom6,
        R.drawable.mushroom7,
        R.drawable.mushroom8,
        R.drawable.mushroom9,
        R.drawable.mushroom10,
    )

    private val broccoli = listOf(
        R.drawable.borccoli_1,
        R.drawable.borccoli_2,
        R.drawable.borccoli_3,
        R.drawable.borccoli_4,
        R.drawable.borccoli_5,
        R.drawable.borccoli_6,
        R.drawable.borccoli_7,
        R.drawable.borccoli_8,
        R.drawable.borccoli_9,
        R.drawable.borccoli_10,
        R.drawable.borccoli_1,
        R.drawable.borccoli_2,
        R.drawable.borccoli_3,
        R.drawable.borccoli_4,
        R.drawable.borccoli_5,
        R.drawable.borccoli_6,
        R.drawable.borccoli_7,
        R.drawable.borccoli_8,
        R.drawable.borccoli_9,
        R.drawable.borccoli_10,
    )

    private val sausage = listOf(
        R.drawable.sausage_1,
        R.drawable.sausage_2,
        R.drawable.sausage_3,
        R.drawable.sausage_4,
        R.drawable.sausage_5,
        R.drawable.sausage_6,
        R.drawable.sausage_7,
        R.drawable.sausage_8,
        R.drawable.sausage_9,
        R.drawable.sausage_10,
        R.drawable.sausage_1,
        R.drawable.sausage_2,
        R.drawable.sausage_3,
        R.drawable.sausage_4,
        R.drawable.sausage_5,
        R.drawable.sausage_6,
        R.drawable.sausage_7,
        R.drawable.sausage_8,
        R.drawable.sausage_9,
        R.drawable.sausage_10,
    )

    private val toppings = listOf(
        PizzaToppingsUiState(PizzaToppings.BASIL, R.drawable.basil_1, false),
        PizzaToppingsUiState(PizzaToppings.BROCCOLI, R.drawable.borccoli_1, false),
        PizzaToppingsUiState(PizzaToppings.ONION, R.drawable.onion2, false),
        PizzaToppingsUiState(PizzaToppings.SAUSAGE, R.drawable.sausage_1, false),
        PizzaToppingsUiState(PizzaToppings.MUSHROOM, R.drawable.mushroom1, false),
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
            PizzaToppingsUiState(PizzaToppings.BASIL, R.drawable.basil, false),
            PizzaToppingsUiState(PizzaToppings.BROCCOLI, R.drawable.borccoli, false),
            PizzaToppingsUiState(PizzaToppings.ONION, R.drawable.onion, false),
            PizzaToppingsUiState(PizzaToppings.SAUSAGE, R.drawable.sausage, false),
            PizzaToppingsUiState(PizzaToppings.MUSHROOM, R.drawable.mushroom, false),
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

        val clickedToppingIndex = _uiState.value.pizzaTypes[clickedPizzaIndex]
                .pizzaToppingsUiState.indexOf(toppingsUiState)

        val alteredToppingsList =
            _uiState.value.pizzaTypes[clickedPizzaIndex].pizzaToppingsUiState.toMutableList()

        if (!toppingsUiState.isSelected) {
            val random = Random
            val randomPositions: MutableList<Pair<Double, Double>> = mutableListOf()

            repeat(20) {
                randomPositions.add(
                    Pair(
                        random.nextDouble(0.15, 0.80),
                        random.nextDouble(0.1, 0.75)
                    )
                )
            }

            val toppingList = when (toppingsUiState.pizzaToppingType) {
                PizzaToppings.BASIL -> basil
                PizzaToppings.BROCCOLI -> broccoli
                PizzaToppings.ONION -> onion
                PizzaToppings.SAUSAGE -> sausage
                PizzaToppings.MUSHROOM -> mushroom
                PizzaToppings.NOTHING -> emptyList()
            }

            alteredToppingsList[clickedToppingIndex] = toppingsUiState.copy(
                    toppingsImages = toppingList,
                    isSelected = true,
                    toppingsPositions = randomPositions
                )
        } else {
            alteredToppingsList[clickedToppingIndex] = toppingsUiState.copy(
                    toppingsImages = emptyList(),
                    isSelected = false,
                    toppingsPositions = emptyList()
                )
        }

        val alteredPizzaUiState = pizzaUiState.copy(pizzaToppingsUiState = alteredToppingsList)

        val alteredPizzaStateList = _uiState.value.pizzaTypes.toMutableList()

        alteredPizzaStateList[clickedPizzaIndex] = alteredPizzaUiState

        _uiState.update { it.copy(pizzaTypes = alteredPizzaStateList) }
    }

}