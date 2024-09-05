package com.sachin.persentation.books

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sachin.data.db.cart.CartEntity
import com.sachin.domain.DomainHelper
import com.sachin.domain.books.useCase.entity.BookDomain
import com.sachin.domain.books.useCase.mapper.toBookDomain
import com.sachin.domain.cart.usecase.mapper.toEntity
import com.sachin.persentation.books.mapper.toBooksViewEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val domainHelper: DomainHelper
) : ViewModel() {

    var books = mutableStateOf<List<BookDomain>>(emptyList())
    var cartBooks = mutableStateOf<List<BookDomain>>(emptyList())

    var selectedBook = mutableStateOf<BookDomain?>(null)


    fun getBooks(searchText: String = "android") {

        val query = searchText.ifEmpty { "android" }

        viewModelScope.launch {
            val result = domainHelper.booksHelper.getBooksUseCase
                .invoke(
                    10,
                    query
                )
            books.value = result
        }
    }

    fun addProductToCart(book: BookDomain) {
        viewModelScope.launch {
            if(book.inCartQty <= 1){
                domainHelper.cartHelper.addBookToCartUseCase.invoke(book)
            }else{
                updateCartItem(book.toEntity())
//                domainHelper.cartHelper.updateCartItemUseCase.invoke(book.toEntity())
            }
        }
    }

    fun removeProductFromCart(book: BookDomain) {
        viewModelScope.launch {
            if(book.inCartQty > 0){
                updateCartItem(book.toEntity())
            }else{
                domainHelper.cartHelper.deleteCartProductUseCase.invoke(book.id)

            }
        }
    }

    fun getCart() {
        books.value = emptyList()
        viewModelScope.launch {
            cartBooks.value = domainHelper.cartHelper.getCartUseCase.execute()
        }
    }

    fun clearCart(){
        viewModelScope.launch {
            domainHelper.cartHelper.clearCartUseCase.invoke()
        }
    }

    fun updateCartItem(cartEntity: CartEntity){
        viewModelScope.launch {
            domainHelper.cartHelper.updateCartItemUseCase.invoke(cartEntity)
        }
    }

}