package com.sachin.domain

import com.sachin.domain.books.BooksHelper
import com.sachin.domain.cart.CartHelper
import javax.inject.Inject

class DomainHelperImpl @Inject
constructor(
    override val cartHelper: CartHelper,
    override val booksHelper: BooksHelper
) : DomainHelper