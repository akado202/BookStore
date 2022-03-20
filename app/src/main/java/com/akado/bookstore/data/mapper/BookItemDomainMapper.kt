package com.akado.bookstore.data.mapper

import com.akado.bookstore.data.model.BookItemData
import com.akado.bookstore.domain.model.BookItemDomainModel

object BookItemDomainMapper : DomainMapper<BookItemData, BookItemDomainModel> {

    override fun mapToModel(from: BookItemData): BookItemDomainModel {
        return BookItemDomainModel(
            title = from.title,
            subTitle = from.subTitle,
            isbn13 = from.isbn13,
            price = from.price,
            image = from.image,
            url = from.url,
        )
    }

}