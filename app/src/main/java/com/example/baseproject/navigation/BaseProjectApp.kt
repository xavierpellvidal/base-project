package com.example.baseproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun BaseProjectApp() {
    val navController = rememberNavController()

    BaseProjectApplicationNavHost(
        navController = navController,
    )
}
