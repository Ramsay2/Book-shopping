package com.sachin.persentation.books.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sachin.domain.books.useCase.entity.BookDomain

@Composable
fun AddToCartButton(
    booksViewEntity: BookDomain,
    onAddToCart: (BookDomain) -> Unit,
    onRemoveFromCart: (BookDomain) -> Unit
) {

    var quantity by remember { mutableIntStateOf(booksViewEntity.inCartQty) }

    if (quantity == 0) {
        Button(
            onClick = {
                quantity++
                onAddToCart.invoke(booksViewEntity.copy(inCartQty = quantity))
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
        ) {
            Text(
                text = "Add",
                fontSize = 12.sp,
            )
        }
    } else {
        // State when item is added: Plus/Minus buttons with quantity display
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                .wrapContentWidth()
                .wrapContentHeight()
        ) {
            IconButton(
                onClick = {
                    if (quantity > 1) {
                        quantity--
                    } else {
                        quantity = 0
                    }
                    onRemoveFromCart.invoke(booksViewEntity.copy(inCartQty = quantity))
                },
                modifier = Modifier
                    .padding(4.dp)
                    .size(12.dp)
            ) {
                Icon(
                    Icons.Default.Delete, contentDescription = "Decrease",
                )
            }

            Text(
                text = quantity.toString(),
                modifier = Modifier
                    .padding(4.dp),
                fontSize = 12.sp
            )

            IconButton(
                onClick = {
                    quantity++
                    onAddToCart.invoke(booksViewEntity.copy(inCartQty = quantity))
                },
                modifier = Modifier
                    .padding(4.dp)
                    .size(12.dp)
            ) {
                Icon(
                    Icons.Default.Add, contentDescription = "Increase",
                )
            }
        }
    }
}