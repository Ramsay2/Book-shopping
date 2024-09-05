package com.sachin.persentation.books.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.sachin.bookshopping.R
import com.sachin.domain.books.useCase.entity.BookDomain

@Composable
fun BookItem(
    book: BookDomain,
    onBookClick: (BookDomain) -> Unit,
    addToCart: (BookDomain) -> Unit,
    removeCart: (BookDomain) -> Unit
) {

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable { onBookClick.invoke(book) },
        border = BorderStroke(0.5.dp, Color.Blue),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            AsyncImage(
                model = book.smallThumbnail,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterVertically)
                    .aspectRatio(0.4f)
                    .padding(top = 8.dp, bottom = 8.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = book.bookName,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(bottom = 4.dp, end = 8.dp),
                    maxLines = 2,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    style =  MaterialTheme.typography.titleSmall.copy(
                        lineHeight = 12.sp
                    )
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Mrp :" + book.price,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(bottom = 8.dp),
                    maxLines = 2,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    style =  MaterialTheme.typography.bodyMedium
                )

            }

            AddToCartButton(book, onAddToCart = { b ->
                addToCart.invoke(b)
            }, { b ->
                removeCart.invoke(b)
            })

        }
    }
}