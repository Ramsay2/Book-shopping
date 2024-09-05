package com.sachin.data.db.cart

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "cart")
data class CartEntity(
    @PrimaryKey
    val itemId: String,
    val timeStamp: Long,
    val title: String,
    val imageUrl: String,
    val imageThumbnail: String,
    val price: String,
    val description: String,
    val inCartQty: Int
)
