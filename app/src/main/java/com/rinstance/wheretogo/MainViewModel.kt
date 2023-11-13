package com.rinstance.wheretogo

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.rinstance.core.navigation.NavigationEvent
import com.rinstance.core.navigation.NavigationEvent.Back
import com.rinstance.core.navigation.NavigationEvent.BackTo
import com.rinstance.core.navigation.NavigationEvent.NavigateTo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    fun handleNavigation(event: NavigationEvent?, navController: NavController) {
        when (event) {
            is NavigateTo -> navController.navigate(event.destination.route)
            is BackTo -> TODO()
            is Back -> navController.navigateUp()
            else -> Unit
        }
    }

}
