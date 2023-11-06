package com.rinstance.core.feature_api.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rinstance.core.navigation.GraphDestination
import com.rinstance.core.navigation.ScreenDestination

interface FeatureEntry

interface ScreenFeatureEntry : FeatureEntry {
    val destination: ScreenDestination

    fun NavGraphBuilder.composable() {
        composable(route = destination.route) {
            Composable()
        }
    }

    @Composable
    fun Composable()
}

interface NavigationFeatureEntry : FeatureEntry {
    val destination: GraphDestination

    fun NavGraphBuilder.buildNavigation()
}
