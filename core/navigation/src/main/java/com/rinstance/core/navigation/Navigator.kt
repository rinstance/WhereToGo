package com.rinstance.core.navigation

import kotlinx.coroutines.flow.StateFlow

interface Navigator {

    val event: StateFlow<NavigationEvent?>

    fun navigateTo(destination: Destination)

    fun newRoot(destination: Destination)

    fun moveBack()

}
