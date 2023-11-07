package com.rinstance.feature.auth.presentation.ui.login

import com.rinstance.core.feature_api.ui.viewmodel.BaseEvent

sealed class LoginEvents : BaseEvent {
    object ToHomeScreen : LoginEvents()
    object ToRegisterScreen : LoginEvents()
}
