package com.akado.bookstore.data.mapper

import com.akado.bookstore.data.model.BookItemData
import com.akado.bookstore.domain.model.BookItemDomainData

object BookItemDomainMapper : DomainMapper<BookItemData, BookItemDomainData> {

    override fun mapToModel(from: BookItemData): BookItemDomainData {
        return BookItemDomainData(
            title = from.title,
            subTitle = from.subTitle,
            isbn13 = from.isbn13,
            price = from.price,
            image = from.image,
            url = from.url,
        )
    }

}