package com.rinstance.feature.auth.api.navigation.destinations

import com.rinstance.core.navigation.ScreenDestination

internal const val LOGIN_ROUTE = "login_screen_route"

class LoginDestination : ScreenDestination() {
    override val route: String = LOGIN_ROUTE
}