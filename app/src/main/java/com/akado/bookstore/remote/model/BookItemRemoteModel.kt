package com.akado.bookstore.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookItemRemoteModel(

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("subtitle")
    @Expose
    val subTitle: String,

    @SerializedName("isbn13")
    @Expose
    val isbn13: String,

    @SerializedName("price")
    @Expose
    val price: String,

    @SerializedName("image")
    @Expose
    val image: String,

    @SerializedName("url")
    @Expose
    val url: String,
)