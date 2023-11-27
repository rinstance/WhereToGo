package com.rinstance.wheretogo.di

import com.rinstance.core.navigation.NavigationHandler
import com.rinstance.core.navigation.Navigator
import com.rinstance.wheretogo.navigation.MainNavigationHandler
import com.rinstance.wheretogo.navigation.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindNavigation(impl: NavigatorImpl): Navigator

    @Binds
    abstract fun bindNavigationHandler(impl: MainNavigationHandler): NavigationHandler

}
