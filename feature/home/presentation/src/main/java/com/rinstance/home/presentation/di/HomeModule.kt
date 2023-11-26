package com.rinstance.home.presentation.di

import com.rinstance.core.feature_api.ui.FeatureEntry
import com.rinstance.home.api.HomeFeatureEntry
import com.rinstance.home.presentation.navigation.HomeFeatureEntryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
internal abstract class HomeModule {

    @Binds
    @IntoMap
    @ClassKey(HomeFeatureEntry::class)
    abstract fun homeGraph(entry: HomeFeatureEntryImpl): FeatureEntry

}
