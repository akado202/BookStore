package com.akado.bookstore.domain.repository

import com.akado.bookstore.domain.model.BookDetailDomainData
import com.akado.bookstore.domain.model.BookItemDomainData
import io.reactivex.Single

interface BookRepository {

    fun getSearchResult(query: String, page: Int): Single<List<BookItemDomainData>>

    fun getBookDetail(isbn13: String): Single<BookDetailDomainData>
}