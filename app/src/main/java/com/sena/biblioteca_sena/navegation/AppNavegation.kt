package com.sena.biblioteca_sena.navegation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sena.biblioteca_sena.ui.screen.BookListScreen
import com.sena.biblioteca_sena.ui.screen.HomeScreen




@Composable
fun AppNavegation(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home,
        modifier = modifier
    ) {
        composable<Home> {
            HomeScreen(
                onirBookList = { navController.navigate(route = BookList) }
            )
        }

        composable<BookList> {
            BookListScreen(
                onirBookDetail = { bookTitle ->
                    // Pendiente: navegar a BookDetail(bookTitle) en feature/book-detail
                }
            )
        }
    }
}