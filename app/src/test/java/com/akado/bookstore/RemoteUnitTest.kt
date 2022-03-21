package com.akado.bookstore

import com.akado.bookstore.di.ApiModule
import com.akado.bookstore.di.NetworkModule
import com.akado.bookstore.remote.api.ApiService
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import java.lang.IllegalArgumentException
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
    fun testGetSearchResultPageOver() {
        println("getSearchResult")
        val page = 101
        apiService.getSearchResult("java", page)
            .doOnSuccess { println("output : $it") }
            .flatMap {
                if (it.page == page)
                    Single.just(it)
                else
                    Single.error(IllegalArgumentException())
            }
            .map { it.books }
            .test()
            .awaitDone(3, TimeUnit.SECONDS)
            .assertError { error -> error is IllegalArgumentException }
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