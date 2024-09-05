package com.sachin.data.http.response.books

import com.google.gson.annotations.SerializedName

data class BooksListResponse(
    @SerializedName("items")
    val books: List<BookResponse>,
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("totalItems")
    val totalItems: Int?
)

data class BookResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo?,
    @SerializedName("saleInfo")
    val saleInfo: SaleInfoResponse?,
)

data class SaleInfoResponse(
    @SerializedName("listPrice")
    val listPrice: ListPriceResponse?,
)

data class ListPriceResponse(
    @SerializedName("amount")
    val amount: Double?,
    @SerializedName("currencyCode")
    val currencyCode: String?
)

data class VolumeInfo(
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("imageLinks")
    val imageLinks: ImageLinksResponse?,
)

data class ImageLinksResponse(
    @SerializedName("smallThumbnail")
    val smallThumbnail: String?,
    @SerializedName("thumbnail")
    val thumbnail: String?
)