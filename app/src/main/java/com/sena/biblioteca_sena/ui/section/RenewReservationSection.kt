package com.sena.biblioteca_sena.ui.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.biblioteca_sena.R
import com.sena.biblioteca_sena.ui.composable.BookCover
import com.sena.biblioteca_sena.ui.composable.DateField
import com.sena.biblioteca_sena.ui.composable.LabeledText
import com.sena.biblioteca_sena.ui.composable.TopBar
import com.sena.biblioteca_sena.ui.composable.WhiteCard
import com.sena.biblioteca_sena.ui.theme.AccentOrange
import com.sena.biblioteca_sena.ui.theme.TextDark

@Composable
fun RenewReservationSection(
    bookTitle: String,
    currentDate: String,
    newDate: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
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

    Column(modifier = modifier) {
        TopBar(
            navigationIconRes = R.drawable.ic_arrow_back,
            navigationDescription = "Volver",
            title = "Renovar Reserva",
            onNavigationClick = onBackClick
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Tarjeta del libro: portada pequeña y nombre
            WhiteCard {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    BookCover(imageRes = coverRes, title = bookTitle, height = 80.dp)
                    Spacer(modifier = Modifier.width(16.dp))
                    LabeledText(label = "Libro:", value = bookTitle)
                }
            }

            // Tarjeta de fechas: la actual arriba, la nueva abajo
            WhiteCard {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = "Reserva Actual:", color = TextDark, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_calendar_month),
                            contentDescription = null,
                            tint = TextDark,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = currentDate, color = TextDark, fontSize = 16.sp)
                    }
                }

                HorizontalDivider(color = Color(0xFFE6E4EE))

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = "Nueva Fecha:", color = TextDark, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                    DateField(date = newDate, color = AccentOrange)
                }
            }
        }
    }
}