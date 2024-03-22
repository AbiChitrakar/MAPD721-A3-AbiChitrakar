
package com.example.mapd721_a3_abichitrakar

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.graphicsLayer
import androidx.navigation.NavController

@Composable
fun TransitionAnimationScreen(navController: NavController) {
    var isLaunched by remember { mutableStateOf(false) }
    var imageYPosition by remember { mutableStateOf(1f) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
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
                text = "TransitionAnimation",
                style = MaterialTheme.typography.bodySmall.copy(color = Color.White), // White color
                modifier = Modifier.padding(start = 8.dp)
            )

            Spacer(modifier = Modifier.width(48.dp))
        }

        Spacer(modifier = Modifier.height(100.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.rocket), // Replace with your image resource id
                contentDescription = "Rocket",
                modifier = Modifier
                    .graphicsLayer {
                        translationY = imageYPosition * 300 // Adjust the multiplier as needed
                    }
            )
        }

        Button(
            onClick = {
                imageYPosition *= -1f
                isLaunched = !isLaunched
            },
            modifier = Modifier.padding(16.dp),
        ) {
            Text(text = if (isLaunched) "Land Rocket" else "Launch Rocket")
        }
    }
}

