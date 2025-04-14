package com.example.core.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface FeatureNavigation {
    fun registerNavGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
    )
}
