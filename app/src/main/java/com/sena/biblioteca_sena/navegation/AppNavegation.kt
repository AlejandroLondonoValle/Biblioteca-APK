package com.sena.biblioteca_sena.navegation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sena.biblioteca_sena.ui.screen.BookListScreen
import com.sena.biblioteca_sena.ui.screen.HomeScreen
import androidx.navigation.toRoute
import com.sena.biblioteca_sena.ui.screen.BookDetailScreen
import com.sena.biblioteca_sena.ui.screen.ReservationConfirmationScreen
import com.sena.biblioteca_sena.ui.screen.MyReservationsScreen
import com.sena.biblioteca_sena.ui.screen.ReservationDetailScreen


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
                    navController.navigate(route = BookDetail(bookTitle = bookTitle))
                }
            )
        }

        composable<BookDetail> { backStackEntry ->
            val detail: BookDetail = backStackEntry.toRoute()
            BookDetailScreen(
                bookTitle = detail.bookTitle,
                onirConfirmation = { bookTitle ->
                    navController.navigate(route = ReservationConfirmation(bookTitle = bookTitle))
                }
            )
        }

        composable<ReservationConfirmation> { backStackEntry ->
            val confirmation: ReservationConfirmation = backStackEntry.toRoute()
            ReservationConfirmationScreen(
                bookTitle = confirmation.bookTitle,
                onirHome = {
                    navController.popBackStack(route = Home, inclusive = false)
                },
                onirMyReservations = {
                    navController.navigate(route = MyReservations) {
                        popUpTo(route = Home)
                    }
                }
            )
        }

        composable<MyReservations> {
            MyReservationsScreen(
                onirReservationDetail = { bookTitle, reservationDate, reservationCode ->
                    navController.navigate(
                        route = ReservationDetail(
                            bookTitle = bookTitle,
                            reservationDate = reservationDate,
                            reservationCode = reservationCode
                        )
                    )
                }
            )
        }

        composable<ReservationDetail> { backStackEntry ->
            val detail: ReservationDetail = backStackEntry.toRoute()
            ReservationDetailScreen(
                bookTitle = detail.bookTitle,
                reservationDate = detail.reservationDate,
                reservationCode = detail.reservationCode,
                onirAtras = { navController.popBackStack() },
                onirRenew = { bookTitle, reservationDate ->
                    // Pendiente: navegar a RenewReservation en feature/renew-reservation
                },
                onirCancel = { navController.popBackStack() }
            )
        }
    }
}