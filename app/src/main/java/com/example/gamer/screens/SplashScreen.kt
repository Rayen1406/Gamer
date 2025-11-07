package com.example.gamer.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gamer.R
import com.example.gamer.nav.AppRoutes
import com.example.gamer.ui.theme.GamerTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    // 🔹 Use LaunchedEffect to run this once when the composable is first shown
    LaunchedEffect(Unit) {
        delay(2000L) // Wait 2 seconds
        navController.navigate(route = "login") {
            // Remove splash from back stack so user can't go back to it
        }
    }

    // 🔹 Display your splash logo / branding
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_gamer),
                contentDescription = "App Logo",
                modifier = Modifier.size(150.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    GamerTheme {
        SplashScreen(navController = rememberNavController())
    }
}
