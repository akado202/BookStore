package com.akado.bookstore.domain.repository

import com.akado.bookstore.domain.model.BookDetailDomainModel
import com.akado.bookstore.domain.model.BookItemDomainModel
import io.reactivex.Single

interface BookRepository {

    fun getSearchResult(query: String, page: Int): Single<List<BookItemDomainModel>>

    fun getBookDetail(isbn13: String): Single<BookDetailDomainModel>
}