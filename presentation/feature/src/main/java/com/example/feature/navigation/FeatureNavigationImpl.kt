package com.example.feature.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.core.presentation.navigation.BaseProjectNavRoutes
import com.example.core.presentation.navigation.FeatureNavigation
import com.example.feature.screen.FeatureScreen
import javax.inject.Inject

class FeatureNavigationImpl
    @Inject
    constructor() : FeatureNavigation {
        override fun registerNavGraph(
            navGraphBuilder: NavGraphBuilder,
            navController: NavHostController,
        ) {
            navGraphBuilder.navigation<BaseProjectNavRoutes.Feature>(
                startDestination = FeatureRoute.Home,
            ) {
                composable<FeatureRoute.Home> {
                    FeatureScreen()
                }
            }
        }
    }
