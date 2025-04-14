package com.example.baseproject.navigation.di

import com.example.core.presentation.navigation.FeatureNavigation
import com.example.feature.navigation.FeatureNavigationImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {
    @Provides
    @IntoSet
    fun provideFeatureNavigation(): FeatureNavigation = FeatureNavigationImpl()
}
