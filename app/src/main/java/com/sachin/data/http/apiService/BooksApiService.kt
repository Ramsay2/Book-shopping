package com.sachin.data.http.apiService

import com.sachin.data.http.GET_BOOKS
import com.sachin.data.http.response.books.BooksListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApiService {

    @GET(GET_BOOKS)
    suspend fun getBooks(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int
    ): Response<BooksListResponse>

}