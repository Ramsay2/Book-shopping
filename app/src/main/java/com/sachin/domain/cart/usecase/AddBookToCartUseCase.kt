package com.sachin.domain.cart.usecase

import com.sachin.data.DataHelper
import com.sachin.data.db.cart.CartEntity
import com.sachin.domain.books.useCase.entity.BookDomain
import com.sachin.domain.cart.usecase.mapper.toEntity

class AddBookToCartUseCase(private val dataHelper: DataHelper) {

    suspend fun invoke(book: BookDomain) {
        dataHelper.databaseHelper.insertCartItem(book.toEntity())
    }

}