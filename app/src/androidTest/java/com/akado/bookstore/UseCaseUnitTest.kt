package com.akado.bookstore

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.akado.bookstore.data.remote.IRemote
import com.akado.bookstore.di.*
import com.akado.bookstore.domain.repository.BookRepository
import com.akado.bookstore.domain.usecase.BookDetailUseCase
import com.akado.bookstore.domain.usecase.BookSearchUseCase
import com.akado.bookstore.remote.api.ApiService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class UseCaseUnitTest {

    private lateinit var retrofit: Retrofit
    private lateinit var apiService: ApiService
    private lateinit var remote:IRemote
    private lateinit var repository: BookRepository

    private lateinit var bookSearchUseCase: BookSearchUseCase
    private lateinit var bookDetailUseCase: BookDetailUseCase

    @Before
    fun setup() {
        retrofit = NetworkModule.provideRetrofit()
        apiService = ApiModule.provideApiService(retrofit)
        remote = RemoteSourceModule.provideDataSource(apiService)
        repository = DataModule.provideBookRepository(remote)

        bookSearchUseCase = DomainModule.provideBookSearchUseCase(repository)
        bookDetailUseCase = DomainModule.provideBookDetailUseCase(repository)
    }

    @Test
    fun testGetSearchResult() {
        println("getSearchResult")
        bookSearchUseCase.getSearchResult("java", 1)
            .doOnNext{ println("output : $it") }
            .test()
            .awaitDone(3, TimeUnit.SECONDS)
            .assertValue { it.isNotEmpty() }
            .assertComplete()
    }

    @Test
    fun testGetBookDetail() {
        println("testGetBookDetail")
        bookDetailUseCase.getBookDetail("9780321812186")
            .doOnNext { println("output : $it") }
            .test()
            .awaitDone(3, TimeUnit.SECONDS)
            .assertComplete()
    }
}