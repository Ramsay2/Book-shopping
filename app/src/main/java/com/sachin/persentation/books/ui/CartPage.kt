package com.sachin.persentation.books.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sachin.persentation.books.BooksViewModel
import com.sachin.persentation.books_info.BookDetailsBottomSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartPage(
    viewModel: BooksViewModel,
    onCartClick: () -> Unit,
    onBackClick: () -> Unit
) {
    viewModel.getCart()
    val books by viewModel.cartBooks

    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }
    Column {
        TopBar(
            title = "Cart",
            buttonText = "Clear Cart",
            backButtonVisible = true,
            onBackClick = { onBackClick.invoke() },
            onCartClick = { onCartClick.invoke() }
        )

        Spacer(modifier = Modifier.width(16.dp))

        LazyColumn {
            items(books) { book ->
                BookItem(book,
                    onBookClick = { b ->
                        viewModel.selectedBook.value = b
                        isSheetOpen = true
                    },
                    addToCart = { b ->
                        viewModel.addProductToCart(b)
                    },
                    removeCart = { b ->
                        viewModel.removeProductFromCart(b)
                    })
            }
        }

        if (isSheetOpen) {
            BookDetailsBottomSheet(sheetState = sheetState, viewModel = viewModel) {
                isSheetOpen = it
            }
        }

    }

}