package com.mr_alhams.quickpizza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mr_alhams.quickpizza.ui.screens.pizza_palette.PizzaPlateScreen
import com.mr_alhams.quickpizza.ui.theme.QuickPizzaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuickPizzaTheme {
                val uiController = rememberSystemUiController()

                uiController.setSystemBarsColor(Color.White)

                PizzaPlateScreen()
            }
        }
    }
}

