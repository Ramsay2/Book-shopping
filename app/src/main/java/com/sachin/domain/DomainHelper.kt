package com.sachin.domain

import com.sachin.domain.books.BooksHelper
import com.sachin.domain.cart.CartHelper

interface DomainHelper {
    val cartHelper: CartHelper
    val booksHelper: BooksHelper
}