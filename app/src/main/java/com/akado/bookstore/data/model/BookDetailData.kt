package com.akado.bookstore.data.model

data class BookDetailData(

    val title: String,
    val subTitle: String,
    val authors: String,
    val publisher: String,
    val language: String,
    val isbn10: String,
    val isbn13: String,
    val pages: Int,
    val year: Int,
    val rating: Int,
    val desc: String,
    val price: String,
    val image: String,
    val url: String,
)