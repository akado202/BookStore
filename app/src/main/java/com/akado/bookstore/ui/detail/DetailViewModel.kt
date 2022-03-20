package com.akado.bookstore.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akado.bookstore.domain.model.BookDetailDomainModel
import com.akado.bookstore.domain.usecase.BookDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailUseCase: BookDetailUseCase
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _item = MutableLiveData<BookDetailDomainModel>()
    val item: LiveData<BookDetailDomainModel> get() = _item

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun request(isbn13: String) {
        detailUseCase.getBookDetail(isbn13)
            .doOnNext { _item.value = it }
            .subscribe()
            .addTo(compositeDisposable)
    }
}