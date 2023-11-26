package com.rinstance.feature.auth.presentation.navigation

import com.rinstance.core.navigation.Navigator
import com.rinstance.feature.auth.api.navigation.destinations.RegisterDestination
import com.rinstance.home.api.denstinations.HomeDestination
import javax.inject.Inject

class AuthNavigator @Inject constructor(
    private val navigator: Navigator
) {

    fun toHomeScreen() {
        navigator.newRoot(HomeDestination())
    }

    fun toRegisterScreen() {
        navigator.navigateTo(RegisterDestination())
    }

    fun backToLogin() {
        navigator.moveBack()
    }

}
