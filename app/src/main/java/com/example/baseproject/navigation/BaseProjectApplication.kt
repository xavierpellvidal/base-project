package com.example.baseproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun BaseProjectApplication() {
    val navController = rememberNavController()

    BaseProjectApplicationNavHost(
        navController = navController,
    )
}
