package com.sena.biblioteca_sena.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.biblioteca_sena.R
import com.sena.biblioteca_sena.ui.composable.ActionButton
import com.sena.biblioteca_sena.ui.composable.ButtonRow
import com.sena.biblioteca_sena.ui.section.ReservationDetailSection
import com.sena.biblioteca_sena.ui.theme.BackgroundLight
import com.sena.biblioteca_sena.ui.theme.DangerRed
import com.sena.biblioteca_sena.ui.theme.SuccessGreen

@Composable
fun ReservationDetailScreen(
    bookTitle: String,
    reservationDate: String,
    reservationCode: String,
    onirAtras: () -> Unit,
    onirRenew: (String, String) -> Unit,
    onirCancel: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
    ) {
        ReservationDetailSection(
            bookTitle = bookTitle,
            reservationDate = reservationDate,
            reservationCode = reservationCode,
            onBackClick = onirAtras,
            modifier = Modifier.weight(1f)
        )

        // Dos botones en la misma fila: se reparten el ancho mitad y mitad
        ButtonRow(modifier = Modifier.padding(vertical = 16.dp)) {
            ActionButton(
                iconRes = R.drawable.ic_autorenew,
                text = "Renovar Reserva",
                color = SuccessGreen,
                onClick = { onirRenew(bookTitle, reservationDate) },
                fontSize = 13.sp
            )
            ActionButton(
                iconRes = R.drawable.ic_close,
                text = "Cancelar Reserva",
                color = DangerRed,
                onClick = onirCancel,
                fontSize = 13.sp
            )
        }
    }
}