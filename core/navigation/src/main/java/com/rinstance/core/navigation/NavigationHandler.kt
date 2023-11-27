package com.rinstance.core.navigation

import androidx.navigation.NavController
import com.rinstance.core.utils.actions.DefAction

interface NavigationHandler {
    fun handleNavigation(
        event: NavigationEvent?,
        navController: NavController,
        onEmptyBackstackAction: DefAction? = null
    )
}
