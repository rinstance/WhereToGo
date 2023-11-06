package com.rinstance.feature.auth.presentation.di

import com.rinstance.core.feature_api.ui.FeatureEntry
import com.rinstance.feature.auth.api.navigation.AuthFeatureEntry
import com.rinstance.feature.auth.presentation.navigation.AuthFeatureEntryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
internal abstract class AuthModule {

    @Binds
    @IntoMap
    @ClassKey(AuthFeatureEntry::class)
    abstract fun favoritesGraph(entry: AuthFeatureEntryImpl): FeatureEntry

}
