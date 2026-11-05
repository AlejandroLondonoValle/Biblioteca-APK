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
import com.sena.biblioteca_sena.ui.section.BookDetailSection
import com.sena.biblioteca_sena.ui.theme.AccentOrange
import com.sena.biblioteca_sena.ui.theme.BackgroundLight

@Composable
fun BookDetailScreen(
    bookTitle: String,
    onirConfirmation: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
    ) {
        BookDetailSection(
            bookTitle = bookTitle,
            modifier = Modifier.weight(1f)
        )

        ButtonRow(modifier = Modifier.padding(vertical = 16.dp)) {
            ActionButton(
                iconRes = R.drawable.ic_bookmark,
                text = "Reservar Libro",
                color = AccentOrange,
                onClick = { onirConfirmation(bookTitle) }
            )
        }
    }
}