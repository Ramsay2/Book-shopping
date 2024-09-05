package com.sachin.domain.books.useCase.mapper

import com.sachin.data.db.cart.CartEntity
import com.sachin.data.http.response.books.BookResponse
import com.sachin.domain.books.useCase.entity.BookDomain
import java.util.Locale
import kotlin.math.roundToInt

fun BookResponse.toBookDomain(cartItems: List<CartEntity>): BookDomain {
    val qty = cartItems.find { it.itemId == id }?.inCartQty ?: 0
    return BookDomain(
        id = id ?: "",
        bookName = volumeInfo?.title ?: "",
        description = volumeInfo?.description ?: "",
        smallThumbnail = volumeInfo?.imageLinks?.smallThumbnail?.replace("http" , "https") ?: "",
        thumbnail = volumeInfo?.imageLinks?.thumbnail?.replace("http" , "https") ?: "",
        price = saleInfo?.listPrice?.amount?.toCurrencyFormat() ?: "Free",
        inCartQty = qty
    )
}



fun Double.toCurrencyFormat(): String {
    val number = if (this % 1 == 0.0) {
        this.roundToInt()
    } else {
        this.toUpToTwoDecimal()
    }
    return java.text.NumberFormat.getNumberInstance(Locale("en", "in")).format(number)
}

fun Double.toUpToTwoDecimal(): Double {
    return String.format("%.2f", this).toDouble()
}