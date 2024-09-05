package com.sachin.domain.books.useCase.entity


data class BookDomain(
    val id: String,
    val bookName: String,
    val description: String,
    val smallThumbnail: String,
    val thumbnail: String,
    val price: String,
    val inCartQty : Int
)