package com.akado.bookstore.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akado.bookstore.domain.model.BookItemDomainModel
import com.akado.bookstore.domain.usecase.BookSearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val searchUseCase: BookSearchUseCase
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _items = MutableLiveData<ArrayList<BookItemDomainModel>>(ArrayList())
    val items: LiveData<ArrayList<BookItemDomainModel>> get() = _items

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun request(query: String) {
        searchUseCase.getSearchResult(query, 1)
            .doOnNext { _items.value = ArrayList(it) }
            .subscribe()
            .addTo(compositeDisposable)
    }
}