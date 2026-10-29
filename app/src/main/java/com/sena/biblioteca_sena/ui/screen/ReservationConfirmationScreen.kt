package com.sena.biblioteca_sena.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.biblioteca_sena.R
import com.sena.biblioteca_sena.ui.composable.ActionButton
import com.sena.biblioteca_sena.ui.composable.ButtonRow
import com.sena.biblioteca_sena.ui.section.ReservationSuccessSection
import com.sena.biblioteca_sena.ui.theme.BrandPurple
import com.sena.biblioteca_sena.ui.theme.SuccessBackground
import com.sena.biblioteca_sena.ui.theme.SuccessGreen

@Composable
fun ReservationConfirmationScreen(
    bookTitle: String,
    onirHome: () -> Unit,
    onirMyReservations: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SuccessBackground),
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically)
    ) {
        ReservationSuccessSection(bookTitle = bookTitle)

        // Botones apilados: uno por fila, cada uno ocupa todo el ancho
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            ButtonRow {
                ActionButton(
                    iconRes = R.drawable.ic_home,
                    text = "Volver al Inicio",
                    color = SuccessGreen,
                    onClick = onirHome
                )
            }
            ButtonRow {
                ActionButton(
                    iconRes = R.drawable.ic_bookmarks,
                    text = "Ver mis Reservas",
                    color = BrandPurple,
                    onClick = onirMyReservations
                )
            }
        }
    }
}