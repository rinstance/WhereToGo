package com.rinstance.wheretogo.navigation

import com.rinstance.core.navigation.Navigator
import javax.inject.Inject

class MainNavigator @Inject constructor(
    private val navigator: Navigator
) {

    fun moveBack() {
        navigator.moveBack()
    }

}
