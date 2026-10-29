package com.sena.biblioteca_sena.ui.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.biblioteca_sena.R
import com.sena.biblioteca_sena.ui.composable.IconInfoItem
import com.sena.biblioteca_sena.ui.composable.SuccessCheckIcon
import com.sena.biblioteca_sena.ui.composable.SuccessTitle
import com.sena.biblioteca_sena.ui.composable.WhiteCard

@Composable
fun ReservationSuccessSection(
    bookTitle: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        SuccessCheckIcon()

        SuccessTitle(text = "Reserva Exitosa")

        WhiteCard {
            IconInfoItem(iconRes = R.drawable.ic_menu_book, label = "Libro:", value = bookTitle)
            IconInfoItem(iconRes = R.drawable.ic_calendar_month, label = "Fecha:", value = "15/06/2026")
        }
    }
}