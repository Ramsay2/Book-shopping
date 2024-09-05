package com.sachin.domain.books

import com.sachin.domain.books.useCase.GetBooksUseCase


interface BooksHelper {
    val getBooksUseCase : GetBooksUseCase

}