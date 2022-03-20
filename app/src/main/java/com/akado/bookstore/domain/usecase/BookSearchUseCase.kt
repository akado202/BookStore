package com.akado.bookstore.domain.usecase

import com.akado.bookstore.domain.model.BookItemDomainModel
import com.akado.bookstore.domain.repository.BookRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BookSearchUseCase @Inject constructor (
    private val repository: BookRepository
) {

    fun getSearchResult(query: String, page: Int): Flowable<List<BookItemDomainModel>> {
        return repository.getSearchResult(query, page)
            .toFlowable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}