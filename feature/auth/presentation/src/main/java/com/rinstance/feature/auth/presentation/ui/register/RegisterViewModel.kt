package com.rinstance.feature.auth.presentation.ui.register

import androidx.compose.runtime.mutableStateOf
import com.rinstance.core.feature_api.ui.viewmodel.BaseEvent
import com.rinstance.core.feature_api.ui.viewmodel.BaseViewModel
import com.rinstance.feature.auth.presentation.navigation.AuthNavigator
import com.rinstance.feature.auth.presentation.ui.register.RegisterEvents.BackToLogin
import com.rinstance.feature.auth.presentation.ui.register.RegisterEvents.Register
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authNavigator: AuthNavigator
) : BaseViewModel() {

    val phoneState = mutableStateOf("")
    val passwordState = mutableStateOf("")
    val confirmPasswordState = mutableStateOf("")

    override fun handleEvent(event: BaseEvent) {
        super.handleEvent(event)
        when (event) {
            is BackToLogin -> authNavigator.backToLogin()
            is Register -> TODO()
        }
    }

}
