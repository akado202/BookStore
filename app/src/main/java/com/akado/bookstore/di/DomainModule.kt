package com.akado.bookstore.di

import com.akado.bookstore.domain.repository.BookRepository
import com.akado.bookstore.domain.usecase.BookDetailUseCase
import com.akado.bookstore.domain.usecase.BookSearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideBookSearchUseCase(repository: BookRepository): BookSearchUseCase {
        return BookSearchUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideBookDetailUseCase(repository: BookRepository): BookDetailUseCase {
        return BookDetailUseCase(repository)
    }
}