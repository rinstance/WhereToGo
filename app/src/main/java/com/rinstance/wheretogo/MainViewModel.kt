package com.rinstance.wheretogo

import androidx.lifecycle.ViewModel
import com.rinstance.wheretogo.navigation.MainNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainNavigator: MainNavigator
) : ViewModel() {

    fun moveBack() {
        mainNavigator.moveBack()
    }

}
