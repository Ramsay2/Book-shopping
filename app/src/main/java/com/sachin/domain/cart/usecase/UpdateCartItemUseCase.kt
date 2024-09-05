package com.sachin.domain.cart.usecase

import com.sachin.data.DataHelper
import com.sachin.data.db.cart.CartEntity

class UpdateCartItemUseCase(val dataHelper: DataHelper) {

    suspend fun invoke(cartItem: CartEntity) {
        dataHelper.databaseHelper.update(cartItem)
    }
}