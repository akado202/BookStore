package com.akado.bookstore.ui.detail

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BookDetailBindingConverter {

    @BindingAdapter("bookDetailThumbnail")
    @JvmStatic
    fun setBookDetailThumbnail(imageView: ImageView, url: String) {
        Glide.with(imageView)
            .load(url)
            .centerCrop()
            .into(imageView)
    }

}