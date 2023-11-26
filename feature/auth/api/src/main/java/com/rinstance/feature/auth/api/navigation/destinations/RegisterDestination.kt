package com.rinstance.feature.auth.api.navigation.destinations

import com.rinstance.core.navigation.ScreenDestination

internal const val REGISTER_ROUTE = "register_screen_route"

class RegisterDestination : ScreenDestination() {
    override val route: String = REGISTER_ROUTE
}
