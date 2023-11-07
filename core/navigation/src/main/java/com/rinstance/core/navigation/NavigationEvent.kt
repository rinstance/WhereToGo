package com.rinstance.core.navigation

sealed class NavigationEvent

data class NavigateTo(val destination: Destination) : NavigationEvent()
