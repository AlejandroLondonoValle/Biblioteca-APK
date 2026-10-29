package com.sena.biblioteca_sena.ui.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.biblioteca_sena.R
import com.sena.biblioteca_sena.ui.theme.BrandPurple
import com.sena.biblioteca_sena.ui.theme.SuccessGreen
import com.sena.biblioteca_sena.ui.theme.TextGray

@Composable
fun ReservationCard(
    @DrawableRes coverRes: Int,
    bookTitle: String,
    reservationDate: String,
    status: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Row: portada a la izquierda, datos a la derecha
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                BookCover(imageRes = coverRes, title = bookTitle, height = 120.dp)
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    LabeledText(label = "Libro:", value = bookTitle)
                    LabeledText(label = "Fecha:", value = reservationDate)
                    Text(text = "Estado:", color = TextGray, fontSize = 13.sp)
                    StatusChip(text = status, color = SuccessGreen)
                }
            }

            ButtonRow {
                ActionButton(
                    iconRes = R.drawable.ic_visibility,
                    text = "Ver Reserva",
                    color = BrandPurple,
                    onClick = onClick
                )
            }
        }
    }
}