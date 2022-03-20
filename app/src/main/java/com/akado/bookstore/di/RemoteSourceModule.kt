package com.akado.bookstore.di

import com.akado.bookstore.data.remote.IRemote
import com.akado.bookstore.remote.api.ApiService
import com.akado.bookstore.remote.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteSourceModule {

    @Provides
    @Singleton
    fun provideDataSource(service: ApiService): IRemote {
        return RemoteDataSource(service)
    }
}