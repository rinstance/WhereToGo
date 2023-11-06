package com.rinstance.feature.auth.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rinstance.feature.auth.api.navigation.AuthFeatureEntry
import com.rinstance.feature.auth.api.navigation.destinations.AuthGraphDestinations
import com.rinstance.feature.auth.api.navigation.destinations.LoginDestination
import com.rinstance.feature.auth.api.navigation.destinations.RegisterDestination
import com.rinstance.feature.auth.presentation.ui.login.LoginScreen
import com.rinstance.feature.auth.presentation.ui.register.RegisterScreen
import javax.inject.Inject

internal class AuthFeatureEntryImpl @Inject constructor(
    override val destination: AuthGraphDestinations
) : AuthFeatureEntry {

    override fun NavGraphBuilder.buildNavigation() {
        navigation(
            route = destination.route,
            startDestination = destination.startDestination
        ) {
            composable(route = LoginDestination().route) {
                LoginScreen()
            }
            composable(route = RegisterDestination().route) {
                RegisterScreen()
            }
        }
    }

}
