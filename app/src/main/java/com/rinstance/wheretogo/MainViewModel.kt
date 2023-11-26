package com.rinstance.wheretogo

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.rinstance.core.navigation.NavigationEvent
import com.rinstance.core.navigation.NavigationEvent.Back
import com.rinstance.core.navigation.NavigationEvent.BackTo
import com.rinstance.core.navigation.NavigationEvent.NavigateTo
import com.rinstance.core.navigation.NavigationEvent.NewRoot
import com.rinstance.wheretogo.navigation.MainNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainNavigator: MainNavigator
) : ViewModel() {

    fun handleNavigation(event: NavigationEvent?, navController: NavController) {
        when (event) {
            is NavigateTo -> navController.navigate(event.destination.route)
            is NewRoot -> navController.navigate(event.destination.route) {
                popUpTo(id = 0)
            }
            is BackTo -> TODO()
            is Back -> navController.navigateUp()
            else -> Unit
        }
    }

    fun moveBack() {
        mainNavigator.moveBack()
    }

}
