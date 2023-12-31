package com.rinstance.feature.auth.presentation.ui.login

import androidx.compose.runtime.mutableStateOf
import com.rinstance.core.feature_api.ui.viewmodel.BaseEvent
import com.rinstance.core.feature_api.ui.viewmodel.BaseViewModel
import com.rinstance.feature.auth.presentation.navigation.AuthNavigator
import com.rinstance.feature.auth.presentation.ui.login.LoginEvents.ToHomeScreen
import com.rinstance.feature.auth.presentation.ui.login.LoginEvents.ToRegisterScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authNavigator: AuthNavigator
) : BaseViewModel() {

    val phoneState = mutableStateOf("")
    val passwordState = mutableStateOf("")

    override fun handleEvent(event: BaseEvent) {
        super.handleEvent(event)
        when (event) {
            is ToHomeScreen -> authNavigator.toHomeScreen()
            is ToRegisterScreen -> authNavigator.toRegisterScreen()
        }
    }

}
