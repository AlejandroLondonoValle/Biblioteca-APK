package com.sena.biblioteca_sena.ui.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.biblioteca_sena.R
import com.sena.biblioteca_sena.ui.composable.BookCover
import com.sena.biblioteca_sena.ui.composable.IconInfoItem
import com.sena.biblioteca_sena.ui.composable.LabeledText
import com.sena.biblioteca_sena.ui.composable.SuccessCheckIcon
import com.sena.biblioteca_sena.ui.composable.WhiteCard
import com.sena.biblioteca_sena.ui.theme.SuccessGreen

@Composable
fun RenewalSuccessSection(
    bookTitle: String,
    newDate: String
) {
    // Datos locales: cada par es (título, portada)
    val covers = listOf(
        "Clean Code" to R.drawable.cover_clean_code,
        "Kotlin para Android" to R.drawable.cover_kotlin_android,
        "Fundamentos de Hardware" to R.drawable.cover_hardware,
        "Jetpack Compose" to R.drawable.cover_jetpack_compose
    )

    // Toma la portada del libro cuyo título llegó como parámetro
    val coverRes = covers.first { it.first == bookTitle }.second

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        SuccessCheckIcon()

        Text(
            text = "Reserva Renovada",
            color = SuccessGreen,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        WhiteCard {
            // Fila del libro: portada pequeña en lugar de ícono
            Row(verticalAlignment = Alignment.CenterVertically) {
                BookCover(imageRes = coverRes, title = bookTitle, height = 44.dp)
                Spacer(modifier = Modifier.width(16.dp))
                LabeledText(label = "Libro:", value = bookTitle)
            }

            IconInfoItem(
                iconRes = R.drawable.ic_calendar_month,
                label = "Nueva Fecha:",
                value = newDate
            )
        }
    }
}