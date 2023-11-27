package com.rinstance.wheretogo

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.rinstance.core.feature_api.ui.GraphFactory
import com.rinstance.core.navigation.NavigationHandler
import com.rinstance.core.navigation.Navigator
import com.rinstance.feature.auth.api.navigation.destinations.AuthGraphDestinations
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var graphFactory: GraphFactory

    @Inject
    lateinit var authDestination: AuthGraphDestinations

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var navigationHandler: NavigationHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainScreen()
            }
        }
    }

    @Composable
    fun MainScreen() {
        val navController = rememberNavController()
        val viewModel = hiltViewModel<MainViewModel>()

        BackPressHandler(viewModel::moveBack)

        LaunchedEffect(key1 = Unit) {
            navigator.event.collect { event ->
                navigationHandler.handleNavigation(event, navController, ::finishAffinity)
            }
        }

        NavHost(
            navController = navController,
            startDestination = authDestination.route,
            builder = graphFactory::setupFeatures
        )
    }

    @Composable
    fun BackPressHandler(onBackPressed: () -> Unit) {
        val currentOnBackPressed = rememberUpdatedState(newValue = onBackPressed)
        val backPressedDispatcher: OnBackPressedDispatcher? =
            LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
        val backCallback = remember {
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    currentOnBackPressed.value.invoke()
                }
            }
        }

        DisposableEffect(key1 = backPressedDispatcher) {
            backPressedDispatcher?.addCallback(backCallback)
            onDispose(backCallback::remove)
        }
    }

}
