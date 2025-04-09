package com.example.feature.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeatureViewModel
    @Inject
    constructor() : ViewModel()
