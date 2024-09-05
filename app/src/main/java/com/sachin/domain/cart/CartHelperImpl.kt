package com.sachin.domain.cart

import com.sachin.data.DataHelper
import com.sachin.data.db.cart.CartEntity
import com.sachin.domain.cart.usecase.AddBookToCartUseCase
import com.sachin.domain.cart.usecase.ClearCartUseCase
import com.sachin.domain.cart.usecase.DeleteCartProductUseCase
import com.sachin.domain.cart.usecase.GetBooksCartUseCase
import com.sachin.domain.cart.usecase.UpdateCartItemUseCase
import javax.inject.Inject

class CartHelperImpl @Inject constructor(
    private val dataHelper: DataHelper
) : CartHelper {
    override val addBookToCartUseCase: AddBookToCartUseCase
        get() = AddBookToCartUseCase(dataHelper)

    override val getCartUseCase: GetBooksCartUseCase
        get() = GetBooksCartUseCase(dataHelper)

    override val clearCartUseCase: ClearCartUseCase
        get() = ClearCartUseCase(dataHelper)

    override val deleteCartProductUseCase: DeleteCartProductUseCase
        get() = DeleteCartProductUseCase(dataHelper)

    override val updateCartItemUseCase: UpdateCartItemUseCase
        get() = UpdateCartItemUseCase(dataHelper)

}