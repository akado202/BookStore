package com.akado.bookstore.remote.source

import com.akado.bookstore.data.model.BookDetailData
import com.akado.bookstore.data.model.BookItemData
import com.akado.bookstore.data.remote.IRemote
import com.akado.bookstore.remote.api.ApiService
import com.akado.bookstore.remote.mapper.BookDetailRemoteMapper
import com.akado.bookstore.remote.mapper.BookItemRemoteMapper
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val service: ApiService
): IRemote {

    override fun getSearchResult(query: String, page: Int): Single<List<BookItemData>> {
        return service.getSearchResult(query, page)
            .map { it.books.map(BookItemRemoteMapper::mapToData) }
    }

    override fun getBookDetail(isbn13: String): Single<BookDetailData> {
        return service.getBookDetail(isbn13)
            .map { BookDetailRemoteMapper.mapToData(it) }
    }
}