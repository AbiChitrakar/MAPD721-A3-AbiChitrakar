package com.example.mapd721_a3_abichitrakar

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.graphicsLayer
import androidx.navigation.NavController

@Composable
fun InfiniteAnimationScreen(navController: NavController) {
    // Define the animation values for scaling
    val scale = remember { Animatable(initialValue = 1f) }

    // Define the infinite scaling animation
    LaunchedEffect(true) {
        while (true) {
            scale.animateTo(
                targetValue = 1.2f, // Zoom in
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 1000),
                    repeatMode = RepeatMode.Reverse
                )
            )
            scale.animateTo(
                targetValue = 1f, // Zoom out
                animationSpec = tween(durationMillis = 1000)
            )
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth() // Fill entire width
                .background(color = Color(0xFFA064C9)), // Purple color
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }

            Text(
                text = "InfiniteAnimation",
                style = MaterialTheme.typography.bodySmall.copy(color = Color.White), // White color
                modifier = Modifier.padding(start = 8.dp)

            )

        }

        Spacer(modifier = Modifier.height(16.dp))

        ScalingButterflyImage(
            painter = painterResource(id = R.drawable.butterfly),
            scaleValue = scale.value
        )
    }
}

@Composable
fun ScalingButterflyImage(
    painter: Painter,
    scaleValue: Float
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .graphicsLayer {
                    scaleX = scaleValue
                    scaleY = scaleValue
                }
        )
    }
}

