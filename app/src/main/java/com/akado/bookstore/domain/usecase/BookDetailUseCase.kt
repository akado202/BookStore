package com.akado.bookstore.domain.usecase

import com.akado.bookstore.domain.model.BookDetailDomainData
import com.akado.bookstore.domain.repository.BookRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BookDetailUseCase @Inject constructor (
    private val repository: BookRepository
) {

    fun getBookDetail(isbn13: String): Flowable<BookDetailDomainData> {
        return repository.getBookDetail(isbn13)
            .toFlowable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}