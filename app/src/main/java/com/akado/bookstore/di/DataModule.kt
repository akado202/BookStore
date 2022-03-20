package com.akado.bookstore.di

import com.akado.bookstore.data.remote.IRemote
import com.akado.bookstore.data.repository.BookRepositoryImpl
import com.akado.bookstore.domain.repository.BookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideBookRepository(
        remote: IRemote,
    ): BookRepository {
        return BookRepositoryImpl(remote)
    }
}