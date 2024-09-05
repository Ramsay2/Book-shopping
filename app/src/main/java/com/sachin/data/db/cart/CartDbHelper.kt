package com.sachin.data.db.cart


interface CartDbHelper {
    suspend fun getCartItems(): List<CartEntity>
    suspend fun insertCartItem(cartItem: CartEntity)
    suspend fun update(cartItem: CartEntity)
    suspend fun deleteCartItem(id: String)
    suspend fun clearCart()

}