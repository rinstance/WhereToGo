package com.rinstance.home.presentation.navigation

import androidx.compose.runtime.Composable
import com.rinstance.core.navigation.ScreenDestination
import com.rinstance.home.api.HomeFeatureEntry
import com.rinstance.home.api.denstinations.HomeDestination
import com.rinstance.home.presentation.ui.HomeScreen
import javax.inject.Inject

internal class HomeFeatureEntryImpl @Inject constructor() : HomeFeatureEntry {

    override val destination: ScreenDestination = HomeDestination()

    @Composable
    override fun Composable() {
        HomeScreen()
    }

}
