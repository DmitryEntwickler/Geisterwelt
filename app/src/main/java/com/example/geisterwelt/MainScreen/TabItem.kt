package com.example.geisterwelt.MainScreen

import androidx.compose.runtime.Composable
import com.example.geisterwelt.R

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var icon: Int, var title: String, var screen: ComposableFun) {
    object World : TabItem(R.drawable.ic_baseline_directions_walk_24, "Welt", { WorldComposable(WorldViewModel()) })
    object Basket : TabItem(R.drawable.ic_baseline_card_travel_24, "Korb", { BasketComposable() })
}
