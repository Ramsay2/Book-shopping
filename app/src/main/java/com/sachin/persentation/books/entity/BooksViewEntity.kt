package com.sachin.persentation.books.entity

data class BooksViewEntity(
    val id: String,
    val bookName: String,
    val description: String,
    val smallThumbnail: String,
    val thumbnail: String,
    val price: String,
    val inCartQty : Int
)
