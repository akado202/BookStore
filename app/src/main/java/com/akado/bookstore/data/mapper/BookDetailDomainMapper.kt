package com.akado.bookstore.data.mapper

import com.akado.bookstore.data.model.BookDetailData
import com.akado.bookstore.domain.model.BookDetailDomainModel

object BookDetailDomainMapper : DomainMapper<BookDetailData, BookDetailDomainModel> {

    override fun mapToModel(from: BookDetailData): BookDetailDomainModel {
        return BookDetailDomainModel(
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