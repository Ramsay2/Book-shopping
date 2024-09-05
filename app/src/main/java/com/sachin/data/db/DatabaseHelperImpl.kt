package com.sachin.data.db

import com.sachin.data.db.cart.CartEntity
import javax.inject.Inject

class DatabaseHelperImpl @Inject
constructor(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getCartItems(): List<CartEntity> {
        return appDatabase.cartDao().getCartBooks()
    }

    override suspend fun insertCartItem(cartItem: CartEntity)  {
        appDatabase.cartDao().addBookToCart(cartItem)
    }

    override suspend fun deleteCartItem(id: String)  {
        appDatabase.cartDao().removeBookFromCart(id)
    }

    override suspend fun clearCart() {
        appDatabase.cartDao().deleteAllProducts()
    }

    override suspend fun update(cartItem: CartEntity) {
        appDatabase.cartDao().update(cartItem)
    }

}