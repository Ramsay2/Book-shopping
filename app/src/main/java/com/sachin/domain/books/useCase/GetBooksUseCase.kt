package com.sachin.domain.books.useCase

import com.sachin.data.DataHelper
import com.sachin.domain.books.useCase.entity.BookDomain
import com.sachin.domain.books.useCase.mapper.toBookDomain

typealias MaxResults = Int
typealias BookName = String

class GetBooksUseCase(val dataHelper: DataHelper) {

    suspend operator fun invoke(
        maxResults: MaxResults,
        bookName: BookName
    ): List<BookDomain> {
        val response = dataHelper.apiHelper.getBooks(
            maxResults = maxResults,
            query = bookName
        )
        val cartProducts = dataHelper.databaseHelper.getCartItems()

        return if (response.isSuccessful) {
            response.body()?.books?.map { it.toBookDomain(cartProducts) } ?: emptyList()
        } else {
            mutableListOf()
        }
    }

}