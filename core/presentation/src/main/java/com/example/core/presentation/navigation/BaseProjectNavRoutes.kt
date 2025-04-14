package com.example.core.presentation.navigation

import kotlinx.serialization.Serializable

sealed class BaseProjectNavRoutes {
    @Serializable
    data object MainGraph : BaseProjectNavRoutes()

    @Serializable
    data object Feature : BaseProjectNavRoutes()
}
