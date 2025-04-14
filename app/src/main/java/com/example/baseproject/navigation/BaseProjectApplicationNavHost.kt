package com.example.baseproject.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigation
import com.example.baseproject.navigation.viewmodel.NavigationViewModel
import com.example.core.presentation.navigation.BaseProjectNavRoutes

@Composable
fun BaseProjectApplicationNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: NavigationViewModel = hiltViewModel(),
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BaseProjectNavRoutes.MainGraph,
    ) {
        navigation<BaseProjectNavRoutes.MainGraph>(
            startDestination = BaseProjectNavRoutes.Feature,
        ) {
            viewModel.subNavigation.forEach { subNavigation ->
                subNavigation.registerNavGraph(
                    navGraphBuilder = this,
                    navController = navController,
                )
            }
        }
    }
}
