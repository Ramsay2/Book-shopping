package com.sachin.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sachin.data.db.cart.CartDao
import com.sachin.data.db.cart.CartEntity

@Database(
    entities = [CartEntity::class],
    version = 6, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cartDao(): CartDao
}