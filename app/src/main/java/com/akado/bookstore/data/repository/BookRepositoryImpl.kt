package com.akado.bookstore.data.repository

import com.akado.bookstore.data.mapper.BookDetailDomainMapper
import com.akado.bookstore.data.mapper.BookItemDomainMapper
import com.akado.bookstore.data.remote.IRemote
import com.akado.bookstore.domain.model.BookDetailDomainData
import com.akado.bookstore.domain.model.BookItemDomainData
import com.akado.bookstore.domain.repository.BookRepository
import io.reactivex.Single
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val remote: IRemote
): BookRepository {

    override fun getSearchResult(query: String, page: Int): Single<List<BookItemDomainData>> {
        return remote.getSearchResult(query, page)
            .map { it.map(BookItemDomainMapper::mapToModel) }
    }

    override fun getBookDetail(isbn13: String): Single<BookDetailDomainData> {
        return remote.getBookDetail(isbn13)
            .map { BookDetailDomainMapper.mapToModel(it) }
    }
}