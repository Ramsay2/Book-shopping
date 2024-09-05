package com.sachin.data.http.provider

import com.sachin.data.http.apiService.BooksApiService


interface ApiServicesProvider {
    val booksApiService: BooksApiService

}