package com.sachin.persentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sachin.persentation.books.ui.BooksPage
import com.sachin.persentation.books.BooksViewModel
import com.sachin.persentation.books.ui.CartPage

@Composable
fun BookApp(viewModel: BooksViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "landing_page") {
        composable("landing_page") {
            BooksPage(
                viewModel = viewModel,
                onCartClick = {
                    navController.navigate("cart_page")
                },
                onBackClick = {
                }
            )
        }

        composable("cart_page") {
            CartPage(
                viewModel = viewModel,
                onCartClick = {
                    viewModel.clearCart()
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

    }
}