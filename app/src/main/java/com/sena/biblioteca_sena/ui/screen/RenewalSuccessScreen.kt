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
import com.sena.biblioteca_sena.ui.section.RenewalSuccessSection
import com.sena.biblioteca_sena.ui.theme.SuccessBackground
import com.sena.biblioteca_sena.ui.theme.SuccessGreen

@Composable
fun RenewalSuccessScreen(
    bookTitle: String,
    newDate: String,
    onirMyReservations: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SuccessBackground),
        verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically)
    ) {
        RenewalSuccessSection(bookTitle = bookTitle, newDate = newDate)

        ButtonRow {
            ActionButton(
                iconRes = R.drawable.ic_home,
                text = "Volver a Mis Reservas",
                color = SuccessGreen,
                onClick = onirMyReservations
            )
        }
    }
}