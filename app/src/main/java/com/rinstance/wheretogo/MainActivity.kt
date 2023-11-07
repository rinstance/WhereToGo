package com.rinstance.wheretogo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.rinstance.core.feature_api.ui.GraphFactory
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

        LaunchedEffect(key1 = true) {
            navigator.event.collect { event ->
                viewModel.handleNavigation(event, navController)
            }
        }

        NavHost(
            navController = navController,
            startDestination = authDestination.route,
            builder = graphFactory::setupFeatures
        )
    }

}
