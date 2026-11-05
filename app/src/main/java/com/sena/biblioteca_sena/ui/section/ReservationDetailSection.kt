package com.sena.biblioteca_sena.ui.section

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.biblioteca_sena.R
import com.sena.biblioteca_sena.ui.composable.BookCover
import com.sena.biblioteca_sena.ui.composable.DashedBox
import com.sena.biblioteca_sena.ui.composable.InfoNote
import com.sena.biblioteca_sena.ui.composable.LabeledText
import com.sena.biblioteca_sena.ui.composable.ParameterBadge
import com.sena.biblioteca_sena.ui.composable.StatusChip
import com.sena.biblioteca_sena.ui.composable.TopBar
import com.sena.biblioteca_sena.ui.theme.AccentOrange
import com.sena.biblioteca_sena.ui.theme.InfoBlue
import com.sena.biblioteca_sena.ui.theme.SuccessGreen
import com.sena.biblioteca_sena.ui.theme.TextGray

@Composable
fun ReservationDetailSection(
    bookTitle: String,
    reservationDate: String,
    reservationCode: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Datos locales: portada y autor de cada libro
    val books = listOf(
        BookSummary(coverRes = R.drawable.cover_clean_code, title = "Clean Code", author = "Robert C. Martin"),
        BookSummary(coverRes = R.drawable.cover_kotlin_android, title = "Kotlin para Android", author = "Antonio J. Gallego y Miguel Á. Lozano"),
        BookSummary(coverRes = R.drawable.cover_hardware, title = "Fundamentos de Hardware", author = "Juan Carlos Moreno Pérez"),
        BookSummary(coverRes = R.drawable.cover_jetpack_compose, title = "Jetpack Compose", author = "Neil Smyth")
    )

    // Toma el libro cuyo título llegó como parámetro
    val book = books.first { it.title == bookTitle }

    Column(modifier = modifier) {
        TopBar(
            navigationIconRes = R.drawable.ic_arrow_back,
            navigationDescription = "Volver",
            title = "Detalle de Reserva",
            onNavigationClick = onBackClick
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ParameterBadge(
                iconRes = R.drawable.ic_check,
                text = "Argumentos recibidos",
                color = SuccessGreen
            )

            // Row: portada a la izquierda, datos a la derecha
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                BookCover(imageRes = book.coverRes, title = book.title, height = 170.dp)

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    LabeledText(label = "Nombre:", value = bookTitle)
                    LabeledText(label = "Autor:", value = book.author)

                    // Datos propios de la reserva, resaltados con borde punteado
                    DashedBox(color = AccentOrange) {
                        LabeledText(label = "Fecha Reserva:", value = reservationDate)
                        LabeledText(label = "Código Reserva:", value = reservationCode)
                        Column {
                            Text(text = "Estado:", color = TextGray, fontSize = 13.sp)
                            StatusChip(text = "Activa", color = SuccessGreen)
                        }
                    }
                }
            }

            InfoNote(
                iconRes = R.drawable.ic_info,
                text = "Estos datos fueron enviados desde la pantalla anterior como parámetros.",
                color = InfoBlue
            )
        }
    }
}

// Molde con la portada y el autor de un libro. Es privado: solo se usa en este archivo.
private data class BookSummary(
    @DrawableRes val coverRes: Int,
    val title: String,
    val author: String
)