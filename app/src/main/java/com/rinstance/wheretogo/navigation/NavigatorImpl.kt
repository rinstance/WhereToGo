package com.rinstance.wheretogo.navigation

import com.rinstance.core.navigation.NavigationEvent
import com.rinstance.core.navigation.Navigator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigatorImpl @Inject constructor() : Navigator {

    private val _event = MutableStateFlow<NavigationEvent?>(null)
    override val event: StateFlow<NavigationEvent?> = _event.asStateFlow()

    override fun navigateTo(event: NavigationEvent) {
        _event.tryEmit(event)
    }

}
