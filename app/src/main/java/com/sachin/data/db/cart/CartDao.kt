package com.sachin.data.db.cart

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBookToCart(book: CartEntity)

    @Query("SELECT * FROM cart")
     suspend fun getCartBooks(): List<CartEntity>

    @Query("DELETE FROM cart WHERE itemId =:id  ")
    suspend fun removeBookFromCart(id: String)

    @Query("DELETE FROM cart")
    suspend fun deleteAllProducts()

    @Update
    suspend fun update(book: CartEntity)
}