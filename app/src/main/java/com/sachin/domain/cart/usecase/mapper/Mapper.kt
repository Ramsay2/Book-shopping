package com.sachin.domain.cart.usecase.mapper

import com.sachin.data.db.cart.CartEntity
import com.sachin.domain.books.useCase.entity.BookDomain
import java.util.Calendar

fun BookDomain.toEntity(): CartEntity {
    return CartEntity(
        itemId = id,
        title = bookName,
        imageUrl = smallThumbnail,
        price = price,
        description = description,
        imageThumbnail = thumbnail,
        timeStamp = Calendar.getInstance().timeInMillis,
        inCartQty = inCartQty
    )
}

fun CartEntity.toDomain(): BookDomain {
    return BookDomain(
        id = itemId,
        bookName = title,
        smallThumbnail  = imageUrl,
        price = price,
        description = description,
        thumbnail =  imageThumbnail,
        inCartQty = inCartQty
    )
}