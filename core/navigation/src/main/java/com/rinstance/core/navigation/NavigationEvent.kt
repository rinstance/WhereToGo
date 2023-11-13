package com.rinstance.core.navigation

sealed class NavigationEvent {
    data class NavigateTo(val destination: Destination) : NavigationEvent()

    data class BackTo(val destination: Destination) : NavigationEvent()
    object Back : NavigationEvent()
}
