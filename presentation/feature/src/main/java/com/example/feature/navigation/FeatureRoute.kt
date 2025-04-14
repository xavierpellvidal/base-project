package com.example.feature.navigation

import kotlinx.serialization.Serializable

sealed class FeatureRoute {
    @Serializable
    data object Home : FeatureRoute()
}
