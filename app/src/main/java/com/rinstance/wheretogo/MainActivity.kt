package com.rinstance.wheretogo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.rinstance.core.feature_api.ui.GraphFactory
import com.rinstance.feature.auth.api.navigation.destinations.AuthGraphDestinations
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var graphFactory: GraphFactory

    @Inject
    lateinit var authDestination: AuthGraphDestinations

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

        NavHost(
            navController = navController,
            startDestination = authDestination.route,
            builder = graphFactory::setupFeatures
        )
    }

}
