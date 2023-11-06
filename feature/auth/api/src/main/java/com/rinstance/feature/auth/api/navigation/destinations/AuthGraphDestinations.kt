package com.rinstance.feature.auth.api.navigation.destinations

import com.rinstance.core.navigation.GraphDestination
import javax.inject.Inject

internal const val AUTH_GRAPH_ROUTE = "auth_graph_route"

class AuthGraphDestinations @Inject constructor() : GraphDestination() {
    override val route: String = AUTH_GRAPH_ROUTE
    override val startDestination: String = LOGIN_ROUTE
}