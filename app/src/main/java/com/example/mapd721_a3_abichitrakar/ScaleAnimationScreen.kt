package com.example.mapd721_a3_abichitrakar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ScaleAnimationScreen(navController: NavController) {
    var scale by remember { mutableStateOf(1f) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        // Custom toolbar with purple background
        Row(
            modifier = Modifier
                .fillMaxWidth() // Fill entire width
                .background(color = Color(0xFFA064C9)), // Purple color
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // Back button with white color
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White) // White color
            }

            // Title with white color
            Text(
                text = "ScaleAnimation",
                style = MaterialTheme.typography.bodySmall.copy(color = Color.White), // White color
                modifier = Modifier.padding(start = 8.dp)

            )

            // Placeholder to align back button and title
            Spacer(modifier = Modifier.width(48.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp,50.dp)
                    .graphicsLayer(scaleX = scale, scaleY = scale)
                    .clickable { scale = if (scale == 1f) 1.2f else 1f }
                    .background(color = Color(0xFF797EF6)), // Purple color
                contentAlignment = Alignment.Center
            )  {
                Text(text = "Scale Animation Button",color= Color.White);

            }
        }
    }
}

@Preview
@Composable
fun ScaleAnimationScreenPreview() {
    ScaleAnimationScreen(navController = rememberNavController())
}

