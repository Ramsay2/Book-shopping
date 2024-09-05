package com.sachin.domain.cart.usecase

import com.sachin.data.DataHelper

class DeleteCartProductUseCase (private val dataHelper: DataHelper) {

    suspend operator fun invoke(id: String)  {
        dataHelper.databaseHelper.deleteCartItem(id)
    }

}