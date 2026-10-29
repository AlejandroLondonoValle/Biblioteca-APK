package com.sena.biblioteca_sena.ui.section

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.biblioteca_sena.R
import com.sena.biblioteca_sena.ui.composable.InfoNote
import com.sena.biblioteca_sena.ui.composable.ReservationCard
import com.sena.biblioteca_sena.ui.composable.TopBar
import com.sena.biblioteca_sena.ui.theme.BrandPurple
import com.sena.biblioteca_sena.ui.theme.TextDark

@Composable
fun MyReservationsSection(
    onReservationClick: (String, String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    // Datos locales de las reservas
    val reservations = listOf(
        Reservation(
            coverRes = R.drawable.cover_clean_code,
            bookTitle = "Clean Code",
            reservationDate = "15/06/2026",
            reservationCode = "RES-2026-001",
            status = "Activa"
        )
    )

    Column(modifier = modifier) {
        TopBar(
            navigationIconRes = R.drawable.ic_menu,
            navigationDescription = "Menú",
            title = "Mis Reservas",
            onNavigationClick = {},
            actionIconRes = R.drawable.ic_bookmarks
        )

        // Encabezado de la lista
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_library_books),
                contentDescription = null,
                tint = BrandPurple,
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Lista de reservas activas",
                color = TextDark,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(reservations, key = { reservation -> reservation.reservationCode }) { reservation ->
                ReservationCard(
                    coverRes = reservation.coverRes,
                    bookTitle = reservation.bookTitle,
                    reservationDate = reservation.reservationDate,
                    status = reservation.status,
                    onClick = {
                        onReservationClick(
                            reservation.bookTitle,
                            reservation.reservationDate,
                            reservation.reservationCode
                        )
                    }
                )
            }
            item {
                InfoNote(
                    iconRes = R.drawable.ic_info,
                    text = "Aquí verás todas tus reservas activas.",
                    color = BrandPurple
                )
            }
        }
    }
}

// Molde de los datos de una reserva. Es privado: solo se usa en este archivo.
private data class Reservation(
    @DrawableRes val coverRes: Int,
    val bookTitle: String,
    val reservationDate: String,
    val reservationCode: String,
    val status: String
)