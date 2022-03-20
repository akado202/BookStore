package com.akado.bookstore.remote.mapper

import com.akado.bookstore.data.model.BookDetailData
import com.akado.bookstore.remote.model.response.DetailResultResponse

object BookDetailRemoteMapper : RemoteMapper<DetailResultResponse, BookDetailData> {

    override fun mapToData(from: DetailResultResponse): BookDetailData {
        return BookDetailData(
            title = from.title,
            subTitle = from.subTitle,
            authors = from.authors,
            publisher = from.publisher,
            language = from.language,
            isbn10 = from.isbn10,
            isbn13 = from.isbn13,
            pages = from.pages,
            year = from.year,
            rating = from.rating,
            desc = from.desc,
            price = from.price,
            image = from.image,
            url = from.url,
        )
    }
}