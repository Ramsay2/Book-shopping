package com.sachin.domain.cart.usecase

import com.sachin.data.DataHelper

class ClearCartUseCase(val dataHelper: DataHelper) {

    suspend operator fun invoke() {
        dataHelper.databaseHelper.clearCart()
    }
}