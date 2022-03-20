package com.akado.bookstore.ui.search

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.akado.bookstore.domain.model.BookItemDomainModel
import com.bumptech.glide.Glide

object BookItemBindingConverter {

    private fun getOrCreateAdapter(recyclerView: RecyclerView): BookItemAdapter {
        return if (recyclerView.adapter != null
            && recyclerView.adapter is BookItemAdapter
        ) {
            recyclerView.adapter as BookItemAdapter
        } else {
            val adapter = BookItemAdapter()
            recyclerView.adapter = adapter
            adapter
        }
    }

    @BindingAdapter("bookItems")
    @JvmStatic
    fun setBookItems(
        recyclerView: RecyclerView,
        items: List<BookItemDomainModel>?
    ) {
        val adapter = getOrCreateAdapter(recyclerView)
        adapter.updateItems(items ?: mutableListOf())
    }

    @BindingAdapter("bookItemThumbnail")
    @JvmStatic
    fun setBookItemThumbnail(imageView: ImageView, url: String) {
        Glide.with(imageView)
            .load(url)
            .centerCrop()
            .into(imageView)
    }

    @BindingAdapter("onItemClick")
    @JvmStatic
    fun setTrackItemClick(
        recyclerView: RecyclerView,
        listener: BookItemAdapter.OnItemClickListener?
    ) {
        val adapter = getOrCreateAdapter(recyclerView)
        adapter.setOnItemClickListener(listener)
    }
}