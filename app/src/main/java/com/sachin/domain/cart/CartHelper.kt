package com.sachin.domain.cart

import com.sachin.domain.cart.usecase.AddBookToCartUseCase
import com.sachin.domain.cart.usecase.ClearCartUseCase
import com.sachin.domain.cart.usecase.DeleteCartProductUseCase
import com.sachin.domain.cart.usecase.GetBooksCartUseCase
import com.sachin.domain.cart.usecase.UpdateCartItemUseCase

interface CartHelper {
    val addBookToCartUseCase: AddBookToCartUseCase
    val getCartUseCase: GetBooksCartUseCase
    val clearCartUseCase: ClearCartUseCase
    val deleteCartProductUseCase: DeleteCartProductUseCase
    val updateCartItemUseCase: UpdateCartItemUseCase
}