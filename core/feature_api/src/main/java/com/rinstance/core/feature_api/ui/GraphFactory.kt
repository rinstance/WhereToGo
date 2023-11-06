package com.rinstance.core.feature_api.ui

import androidx.navigation.NavGraphBuilder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GraphFactory @Inject constructor(
    private val entries: Map<@JvmSuppressWildcards Class<*>, @JvmSuppressWildcards FeatureEntry>
) {

    fun setupFeatures(graphBuilder: NavGraphBuilder) {
        entries.forEach { entry ->
            val featureEntry = entry.value
            graphBuilder.addEntryByType(featureEntry)
        }
    }

    private fun NavGraphBuilder.addEntryByType(featureEntry: FeatureEntry) {
        when (featureEntry) {
            is ScreenFeatureEntry -> with(featureEntry) { composable() }
            is NavigationFeatureEntry -> with(featureEntry) { buildNavigation() }
        }
    }

}
