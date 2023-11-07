package com.rinstance.core.feature_api.ui.viewmodel

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    open fun handleEvent(event: BaseEvent) = Unit

}
