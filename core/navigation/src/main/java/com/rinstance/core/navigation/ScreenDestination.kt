package com.rinstance.core.navigation

abstract class Destination {
    abstract val route: String
}

abstract class ScreenDestination : Destination()

abstract class GraphDestination : Destination() {
    abstract val startDestination: String
}
