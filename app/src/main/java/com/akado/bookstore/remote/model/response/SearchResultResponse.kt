package com.akado.bookstore.remote.model.response

import com.akado.bookstore.remote.model.BookItemRemoteModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchResultResponse(

    @SerializedName("error")
    @Expose
    val error: Int,

    @SerializedName("total")
    @Expose
    val total: Int,

    @SerializedName("page")
    @Expose
    val page: Int,

    @SerializedName("books")
    @Expose
    val books: List<BookItemRemoteModel>
)
