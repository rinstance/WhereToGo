package com.rinstance.feature.auth.presentation.ui.register

import com.rinstance.core.feature_api.ui.viewmodel.BaseEvent

sealed class RegisterEvents : BaseEvent {
    object BackToLogin : RegisterEvents()
    object Register : RegisterEvents()
}
