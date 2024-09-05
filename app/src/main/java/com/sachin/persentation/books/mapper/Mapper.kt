package com.sachin.persentation.books.mapper

import com.sachin.data.db.cart.CartEntity
import com.sachin.domain.books.useCase.entity.BookDomain
import com.sachin.persentation.books.entity.BooksViewEntity

fun BookDomain.toBooksViewEntity(entity : List<CartEntity>) : BooksViewEntity{
    val cartEntity = entity.filter { it.itemId == id }.size
    return BooksViewEntity(
        id = id,
        bookName = bookName,
        description = description,
        smallThumbnail = smallThumbnail,
        thumbnail = thumbnail,
        price = price,
        inCartQty = cartEntity

    )

}