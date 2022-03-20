package com.akado.bookstore.data.remote

import com.akado.bookstore.data.model.BookDetailData
import com.akado.bookstore.data.model.BookItemData
import io.reactivex.Single

interface IRemote {

    fun getSearchResult(query: String, page: Int): Single<List<BookItemData>>

    fun getBookDetail(isbn13: String): Single<BookDetailData>
}