package com.sachin.persentation.books_info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.sachin.bookshopping.R
import com.sachin.domain.books.useCase.entity.BookDomain
import com.sachin.persentation.books.BooksViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetailsBottomSheet(
    sheetState: SheetState,
    viewModel: BooksViewModel,
    sheetOpen: (Boolean) -> Unit
) {
    ModalBottomSheet(
        modifier = Modifier.fillMaxHeight(LocalConfiguration.current.screenHeightDp * 0.7f),
        sheetState = sheetState,
        onDismissRequest = {
            sheetOpen.invoke(false)
        },
        sheetMaxWidth = LocalConfiguration.current.screenHeightDp.dp * 0.7f
    ) {
        viewModel.selectedBook.value?.let {
            BottomSheetContent(it)
        }
    }
}

@Composable
fun BottomSheetContent(book: BookDomain) {
    val screenHeight = LocalConfiguration.current.screenHeightDp
    val sheetHeight = screenHeight * 0.7f

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(sheetHeight)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = book.thumbnail,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .aspectRatio(1f)
        )
        Spacer(modifier = Modifier.padding(top = 8.dp))

        Text(
            text = book.bookName,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp),
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            style =  MaterialTheme.typography.titleSmall.copy(
                lineHeight = 12.sp
            )
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        Text(
            text = "Mrp: " + book.price,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            style =  MaterialTheme.typography.titleSmall.copy(
                lineHeight = 12.sp
            )
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        Text(
            text = book.description,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            style =  MaterialTheme.typography.titleSmall.copy(
                lineHeight = 12.sp
            )
        )
    }
}