package com.rinstance.core.utils.actions

import androidx.compose.runtime.Composable

typealias DefAction = () -> Unit

typealias DefComposableAction = @Composable () -> Unit

typealias ParamAction<T> = (T) -> Unit

typealias ReturnAction<T> = () -> T
