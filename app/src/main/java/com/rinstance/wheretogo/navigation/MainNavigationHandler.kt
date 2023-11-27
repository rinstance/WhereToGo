package com.rinstance.wheretogo.navigation

import android.util.Log
import androidx.navigation.NavController
import com.rinstance.core.navigation.NavigationEvent
import com.rinstance.core.navigation.NavigationEvent.Back
import com.rinstance.core.navigation.NavigationEvent.BackTo
import com.rinstance.core.navigation.NavigationEvent.NavigateTo
import com.rinstance.core.navigation.NavigationEvent.NewRoot
import com.rinstance.core.navigation.NavigationHandler
import com.rinstance.core.utils.actions.DefAction
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainNavigationHandler @Inject constructor(): NavigationHandler {
    override fun handleNavigation(
        event: NavigationEvent?,
        navController: NavController,
        onEmptyBackstackAction: DefAction?
    ) {
        Log.d("loggg", "event $event")
        when (event) {
            is NavigateTo -> navController.navigate(event.destination.route)
            is NewRoot -> navController.navigate(event.destination.route) {
                popUpTo(id = 0)
            }
            is BackTo -> TODO()
            is Back -> if (!navController.popBackStack()) onEmptyBackstackAction?.invoke()
            else -> Unit
        }
    }
}
