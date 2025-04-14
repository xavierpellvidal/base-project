package com.example.baseproject.navigation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.core.presentation.navigation.FeatureNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel
    @Inject
    constructor(
        private val featureNavigation: Set<@JvmSuppressWildcards FeatureNavigation>,
    ) : ViewModel() {
        val subNavigation = featureNavigation
    }
