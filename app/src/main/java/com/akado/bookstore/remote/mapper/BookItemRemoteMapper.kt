package com.akado.bookstore.remote.mapper

import com.akado.bookstore.data.model.BookItemData
import com.akado.bookstore.remote.model.BookItemRemoteModel

object BookItemRemoteMapper : RemoteMapper<BookItemRemoteModel, BookItemData> {

    override fun mapToData(from: BookItemRemoteModel): BookItemData {
        return BookItemData(
            title = from.title,
            subTitle = from.subTitle,
            isbn13 = from.isbn13,
            price = from.price,
            image = from.image,
            url = from.url,
        )
    }
}