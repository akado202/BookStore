package com.akado.bookstore

import com.akado.bookstore.di.ApiModule
import com.akado.bookstore.di.NetworkModule
import com.akado.bookstore.remote.api.ApiService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class RemoteUnitTest {

    private lateinit var retrofit: Retrofit
    private lateinit var apiService: ApiService

    @Before
    fun setup() {
        retrofit = NetworkModule.provideRetrofit()
        apiService = ApiModule.provideApiService(retrofit)
    }

    @Test
    fun testGetSearchResult() {
        println("getSearchResult")
        apiService.getSearchResult("java", 1)
            .doOnSuccess { println("output : $it") }
            .map { it.books }
            .test()
            .awaitDone(3, TimeUnit.SECONDS)
            .assertValue { it.isNotEmpty() }
            .assertComplete()
    }

    @Test
    fun testGetBookDetail() {
        println("testGetBookDetail")
        apiService.getBookDetail("9780321812186")
            .doOnSuccess { println("output : $it") }
            .test()
            .awaitDone(3, TimeUnit.SECONDS)
            .assertValue { it.error == 0 }
            .assertComplete()
    }
}