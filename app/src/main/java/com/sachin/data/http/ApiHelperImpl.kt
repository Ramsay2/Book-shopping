package com.sachin.data.http

import com.sachin.data.http.apiService.BooksApiService
import com.sachin.data.http.provider.ApiServicesProvider
import com.sachin.data.http.response.books.BooksListResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject
constructor(
    override val booksApiService: BooksApiService
) : ApiHelper, ApiServicesProvider {

    override suspend fun getBooks(query: String, maxResults: Int): Response<BooksListResponse> {
        return booksApiService.getBooks(query, maxResults)
    }

}