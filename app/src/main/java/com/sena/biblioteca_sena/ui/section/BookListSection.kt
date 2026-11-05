package com.sena.biblioteca_sena.ui.section

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.sena.biblioteca_sena.ui.composable.BookCard
import com.sena.biblioteca_sena.ui.theme.AccentOrange
import com.sena.biblioteca_sena.ui.theme.BlueAquamarine
import com.sena.biblioteca_sena.ui.theme.BrandPurple
import com.sena.biblioteca_sena.ui.theme.SuccessGreen
import com.sena.biblioteca_sena.ui.theme.TextDark
import com.sena.biblioteca_sena.ui.theme.TextGray

@Composable
fun BookListSection(
    onBookClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    // Datos locales de los libros
    val books = listOf(
        Book(iconRes = R.drawable.ic_description, iconColor = BrandPurple, title = "Clean Code"),
        Book(iconRes = R.drawable.ic_android, iconColor = SuccessGreen, title = "Kotlin para Android"),
        Book(iconRes = R.drawable.ic_memory, iconColor = AccentOrange, title = "Fundamentos de Hardware"),
        Book(iconRes = R.drawable.ic_layers, iconColor = BlueAquamarine, title = "Jetpack Compose")
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Encabezado: ícono + título, y subtítulo debajo
        Column(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 24.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu_book),
                    contentDescription = null,
                    tint = BrandPurple,
                    modifier = Modifier.size(26.dp)
                )
                Text(
                    text = "Mis Libros",
                    color = TextDark,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Text(
                text = "Elige un libro para ver más detalles.",
                color = TextGray,
                fontSize = 14.sp
            )
        }

        LazyColumn(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(books, key = { book -> book.title }) { book ->
                BookCard(
                    iconRes = book.iconRes,
                    iconColor = book.iconColor,
                    title = book.title,
                    onClick = { onBookClick(book.title) }
                )
            }
        }
    }
}

// Molde de los datos de un libro en la lista. Es privado: solo se usa en este archivo.
private data class Book(
    @DrawableRes val iconRes: Int,
    val iconColor: Color,
    val title: String
)