package com.sachin.persentation.books.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sachin.bookshopping.R
import com.sachin.persentation.books.BooksViewModel
import com.sachin.persentation.books_info.BookDetailsBottomSheet


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BooksPage(
    viewModel: BooksViewModel,
    onCartClick: () -> Unit,
    onBackClick: () -> Unit
) {
    val books by viewModel.books
    viewModel.getBooks()

    val text by remember { mutableStateOf(TextFieldValue("")) }

    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    Column {
        TopBar(
            title = "Books",
            buttonText = "Cart",
            backButtonVisible = false,
            onBackClick = { onBackClick.invoke() },
            onCartClick = {
                viewModel.books.value = emptyList()
                onCartClick.invoke()
            }
        )

        Spacer(modifier = Modifier.width(8.dp))

        SearchView(
            query = text.text,
            onSearch = { viewModel.getBooks(it) },
            modifier = Modifier.padding(16.dp)
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

    }

    if (isSheetOpen) {
        BookDetailsBottomSheet(sheetState = sheetState, viewModel = viewModel) {
            isSheetOpen = it
        }
    }
}

@Composable
fun SearchView(
    query: String,
    onSearch: (String) -> Unit,
    modifier: Modifier
) {
    var text by remember { mutableStateOf(query) }

    Box(
        modifier = modifier
            .background(Color.White, RoundedCornerShape(8.dp))
            .border(BorderStroke(1.dp, Color.Gray), RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .fillMaxWidth(),

        ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search), // Replace with your search icon
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            BasicTextField(
                value = text,
                onValueChange = {
                    text = it
                    onSearch(it)
                },
                singleLine = true,
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                ),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = {
                    onSearch(text)
                }),
                modifier = Modifier
                    .weight(1f)
                    .padding(0.dp)
            )

            if (text.isNotEmpty()) {
                IconButton(onClick = {
                    text = ""
                    onSearch("")
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_cancel_dialog), // Replace with your clear icon
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}




