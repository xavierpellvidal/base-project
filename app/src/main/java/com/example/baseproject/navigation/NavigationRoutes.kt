package com.example.baseproject.navigation

import kotlinx.serialization.Serializable

sealed class NavigationRoutes {
    @Serializable
    data object MainGraph : NavigationRoutes()

    @Serializable
    data object Feature : NavigationRoutes()
}
