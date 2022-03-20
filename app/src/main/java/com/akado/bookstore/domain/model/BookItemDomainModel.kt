package com.akado.bookstore.domain.model

data class BookItemDomainModel(

    val title: String,
    val subTitle: String,
    val isbn13: String,
    val price: String,
    val image: String,
    val url: String
)