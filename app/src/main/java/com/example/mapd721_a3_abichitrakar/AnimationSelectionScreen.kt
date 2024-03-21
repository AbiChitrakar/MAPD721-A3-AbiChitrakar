package com.example.mapd721_a3_abichitrakar

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun AnimationSelectionScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { navController.navigate("transitionScreen") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Transition Animation")
        }
        Button(
            onClick = { navController.navigate("scaleScreen") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Scale Animation")
        }
        Button(
            onClick = { navController.navigate("infiniteScreen") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Infinite Animation")
        }
        Button(
            onClick = { navController.navigate("exitScreen") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Enter Exit Animation")
        }
    }
}
