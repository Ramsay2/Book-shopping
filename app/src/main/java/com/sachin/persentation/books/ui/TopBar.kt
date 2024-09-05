package com.sachin.persentation.books.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sachin.bookshopping.R

@Composable
fun TopBar(
    title: String,
    buttonText: String,
    backButtonVisible: Boolean,
    onCartClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        if (backButtonVisible) {
            Spacer(modifier = Modifier.width(4.dp))
            IconButton(
                onClick = { onBackClick.invoke() },
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "back")
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {

            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = title,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 16.dp),
                maxLines = 2,
                fontFamily = FontFamily(Font(R.font.poppins_bold))
            )
        }

        Button(
            onClick = { onCartClick.invoke() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
        ) {
            Text(
                text = buttonText,
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold))
            )
        }
    }
}