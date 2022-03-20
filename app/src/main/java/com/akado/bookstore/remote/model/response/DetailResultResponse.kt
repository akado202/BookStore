package com.akado.bookstore.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DetailResultResponse(

    @SerializedName("error")
    @Expose
    val error: Int,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("subtitle")
    @Expose
    val subTitle: String,

    @SerializedName("authors")
    @Expose
    val authors: String,

    @SerializedName("publisher")
    @Expose
    val publisher: String,

    @SerializedName("language")
    @Expose
    val language: String,

    @SerializedName("isbn10")
    @Expose
    val isbn10: String,

    @SerializedName("isbn13")
    @Expose
    val isbn13: String,

    @SerializedName("pages")
    @Expose
    val pages: Int,

    @SerializedName("year")
    @Expose
    val year: Int,

    @SerializedName("rating")
    @Expose
    val rating: Int,

    @SerializedName("desc")
    @Expose
    val desc: String,

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
