package  com.example.mapd721_a3_abichitrakar
//
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun EnterExitAnimationScreen(navController: NavController) {
    var isImageVisible by remember { mutableStateOf(false) }

    val animationSpec = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = 500, // Adjust the duration as needed
                easing = FastOutSlowInEasing // Adjust the easing function as needed
            )
        ) + slideInVertically(
            initialOffsetY = { it },
            animationSpec = TweenSpec(
                durationMillis = 500, // Adjust the duration as needed
                easing = FastOutSlowInEasing // Adjust the easing function as needed
            )
        ) to fadeOut(
            animationSpec = TweenSpec(
                durationMillis = 500, // Adjust the duration as needed
                easing = FastOutSlowInEasing // Adjust the easing function as needed
            )
        ) + slideOutVertically(
            targetOffsetY = { -it },
            animationSpec = TweenSpec(
                durationMillis = 500, // Adjust the duration as needed
                easing = FastOutSlowInEasing // Adjust the easing function as needed
            )
        )
    }

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
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                ) // White color
            }

            // Title with white color
            Text(
                text = if (isImageVisible) "Press for Exit Animation" else "Press for Enter Animation",
                style = MaterialTheme.typography.bodySmall.copy(color = Color.White), // White color
                modifier = Modifier.padding(start = 8.dp)
            )

            // Placeholder to align back button and title
            Spacer(modifier = Modifier.width(48.dp))
        }

        // Box to align image at top center
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image with enter/exit animation
            AnimatedVisibility(
                visible = isImageVisible,
                enter = animationSpec.first,
                exit = animationSpec.second
            ) {
                Image(
                    painter = painterResource(id = R.drawable.butterfly), // Placeholder, replace with your image resource
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Gray)
                )
            }

            // Button to trigger animation
            Button(
                onClick = {
                    isImageVisible = !isImageVisible
                },
                modifier = Modifier
                    .padding(bottom = 16.dp)
            ) {
                Text(text = if (isImageVisible) "Press for Exit Animation" else "Press for Enter Animation")
            }
        }
    }
}

//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.res.painterResource
//import androidx.navigation.NavController
//import androidx.compose.animation.fadeIn
//import androidx.compose.animation.fadeOut
//import androidx.compose.animation.slideInVertically
//import androidx.compose.animation.slideOutVertically
//
//
//@Composable
//fun EnterExitAnimationScreen(navController: NavController) {
//    var isImageVisible by remember { mutableStateOf(false) }
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Top
//    ) {
//        // Custom toolbar with purple background
//        Row(
//            modifier = Modifier
//                .fillMaxWidth() // Fill entire width
//                .background(color = Color(0xFFA064C9)), // Purple color
//            verticalAlignment = Alignment.CenterVertically,
//        ) {
//            // Back button with white color
//            IconButton(onClick = { navController.navigateUp() }) {
//                Icon(
//                    Icons.Default.ArrowBack,
//                    contentDescription = "Back",
//                    tint = Color.White
//                ) // White color
//            }
//
//            // Title with white color
//            Text(
//                text = if (isImageVisible) "Press for Exit Animation" else "Press for Enter Animation",
//                style = MaterialTheme.typography.bodySmall.copy(color = Color.White), // White color
//                modifier = Modifier.padding(start = 8.dp)
//            )
//
//            // Placeholder to align back button and title
//            Spacer(modifier = Modifier.width(48.dp))
//        }
//
//        // Box to align image at top center
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            // Image with enter/exit animation
//            AnimatedVisibility(
//                visible = isImageVisible,
//                enter = fadeIn() + slideInVertically(),
//                exit = fadeOut() + slideOutVertically()
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.butterfly), // Placeholder, replace with your image resource
//                    contentDescription = null,
//                    modifier = Modifier
//                        .size(200.dp)
//                        .clip(RoundedCornerShape(8.dp))
//                        .background(Color.Gray)
//                )
//            }
//
//            // Button to trigger animation
//            Button(
//                onClick = {
//                    isImageVisible = !isImageVisible
//                },
//                modifier = Modifier
//                    .padding(bottom = 16.dp)
//            ) {
//                Text(text = if (isImageVisible) "Press for Exit Animation" else "Press for Enter Animation")
//            }
//        }
//    }
//}
