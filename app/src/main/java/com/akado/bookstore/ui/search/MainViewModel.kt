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

    private val _query = MutableLiveData<String>(null)
    private val _page = MutableLiveData(1)
    private val _isLoading = MutableLiveData(false)
    private val _hasMore = MutableLiveData(true)

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun request(query: String) {
        if (_query.value != query) {
            compositeDisposable.clear()
            _items.value = ArrayList()
            _query.value = query
            _page.value = 1
            _isLoading.value = false
            _hasMore.value = true
        }

        if (_isLoading.value == true || _hasMore.value == false) {
            return
        }

        searchUseCase.getSearchResult(_query.value!!, _page.value!!)
            .doOnSubscribe { _isLoading.value = true }
            .doFinally{ _isLoading.value = false }
            .doOnNext { _page.value = (_page.value ?: 1) + 1 }
            .doOnNext { _items.value!!.addAll(it) }
            .doOnNext { _items.value = _items.value }
            .subscribe()
            .addTo(compositeDisposable)
    }
}