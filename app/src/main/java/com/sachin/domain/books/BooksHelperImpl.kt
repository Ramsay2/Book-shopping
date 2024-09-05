package com.sachin.domain.books

import com.sachin.data.DataHelper
import com.sachin.domain.books.useCase.GetBooksUseCase
import javax.inject.Inject

class BooksHelperImpl @Inject constructor(
    private val dataHelper: DataHelper
) : BooksHelper {

    override val getBooksUseCase: GetBooksUseCase
        get() = GetBooksUseCase(dataHelper)

}