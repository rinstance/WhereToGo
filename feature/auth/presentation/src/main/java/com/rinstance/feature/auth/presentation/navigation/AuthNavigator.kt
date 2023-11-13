package com.rinstance.feature.auth.presentation.navigation

import com.rinstance.core.navigation.Navigator
import com.rinstance.feature.auth.api.navigation.destinations.LoginDestination
import com.rinstance.feature.auth.api.navigation.destinations.RegisterDestination
import javax.inject.Inject

class AuthNavigator @Inject constructor(
    private val navigator: Navigator
) {

    fun toHomeScreen() {
        TODO("home navigation")
    }

    fun toRegisterScreen() {
        navigator.navigateTo(RegisterDestination())
    }

    fun backToLogin() {
        navigator.moveBack()
    }

}
