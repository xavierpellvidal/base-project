package com.example.baseproject.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.feature.screen.FeatureScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BaseProjectApplicationNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavigationRoutes.MainGraph,
    ) {
        navigation<NavigationRoutes.MainGraph>(
            startDestination = NavigationRoutes.Feature,
        ) {
            composable<NavigationRoutes.Feature> {
                FeatureScreen()
            }
        }
    }
}
