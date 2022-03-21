package com.akado.bookstore.ui.search

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LoadMoreOnScrollListener(
    private val callback: Callback
) : RecyclerView.OnScrollListener() {

    private val visibleThreshold = 5

    interface Callback {
        fun loadMore()
    }

    override fun onScrolled(view: RecyclerView, dx: Int, dy: Int) {
        if (dx == 0 && dy == 0) return

        val layoutManager: LinearLayoutManager = view.layoutManager as LinearLayoutManager
        if (view.adapter != null
            && layoutManager.findLastVisibleItemPosition() >= view.adapter!!.itemCount - visibleThreshold) {
            callback.loadMore()
        }
    }
}