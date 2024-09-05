package com.sachin.domain.cart.usecase

import android.util.Log
import com.sachin.data.DataHelper
import com.sachin.domain.books.useCase.entity.BookDomain
import com.sachin.domain.cart.usecase.mapper.toDomain


class GetBooksCartUseCase(private val dataHelper: DataHelper) {

    suspend fun execute(): List<BookDomain> {
        val items = dataHelper.databaseHelper.getCartItems()
        Log.e("cart_items" , "$items")
        return items.map { it.toDomain() }
    }
}

