package com.akado.bookstore.remote.api

import com.akado.bookstore.remote.model.response.DetailResultResponse
import com.akado.bookstore.remote.model.response.SearchResultResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("search/{query}/{page}")
    fun getSearchResult(
        @Path("query") query: String,
        @Path("page") page: Int
    ): Single<SearchResultResponse>

    @GET("books/{isbn13}")
    fun getBookDetail(
        @Path("isbn13") isbn13: String
    ): Single<DetailResultResponse>
}