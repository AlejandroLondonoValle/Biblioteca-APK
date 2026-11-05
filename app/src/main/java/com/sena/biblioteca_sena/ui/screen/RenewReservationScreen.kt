package com.sena.biblioteca_sena.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.biblioteca_sena.R
import com.sena.biblioteca_sena.ui.composable.ActionButton
import com.sena.biblioteca_sena.ui.composable.ButtonRow
import com.sena.biblioteca_sena.ui.section.RenewReservationSection
import com.sena.biblioteca_sena.ui.theme.AccentOrange
import com.sena.biblioteca_sena.ui.theme.BackgroundLight

@Composable
fun RenewReservationScreen(
    bookTitle: String,
    currentDate: String,
    onirAtras: () -> Unit,
    onirRenewalSuccess: (String, String) -> Unit
) {
    // Nueva fecha fija de ejemplo: es la que se envía como parámetro "fechaNueva"
    val newDate = "30/06/2026"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
    ) {
        RenewReservationSection(
            bookTitle = bookTitle,
            currentDate = currentDate,
            newDate = newDate,
            onBackClick = onirAtras,
            modifier = Modifier.weight(1f)
        )

        ButtonRow(modifier = Modifier.padding(vertical = 16.dp)) {
            ActionButton(
                iconRes = R.drawable.ic_check,
                text = "Confirmar Renovación",
                color = AccentOrange,
                onClick = { onirRenewalSuccess(bookTitle, newDate) }
            )
        }
    }
}