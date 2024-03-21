package com.example.mapd721_a3_abichitrakar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "animationSelectionScreen") {
                composable("animationSelectionScreen") {
                    AnimationSelectionScreen(navController = navController)
                }
                composable("transitionScreen") {
                    TransitionAnimationScreen(navController = navController)
                }
                composable("scaleScreen") {
                    ScaleAnimationScreen(navController= navController)
                }
                composable("infiniteScreen") {
                    InfiniteAnimationScreen(navController= navController)
                }
                composable("exitScreen") {
                    EnterExitAnimationScreen(navController= navController)
                }


            }
        }
    }
}
