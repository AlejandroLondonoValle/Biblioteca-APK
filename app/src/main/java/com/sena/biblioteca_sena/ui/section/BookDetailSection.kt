package com.sena.biblioteca_sena.ui.section

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.biblioteca_sena.R
import com.sena.biblioteca_sena.ui.composable.BookCover
import com.sena.biblioteca_sena.ui.composable.InfoRow
import com.sena.biblioteca_sena.ui.composable.ParameterBadge
import com.sena.biblioteca_sena.ui.theme.AccentOrange
import com.sena.biblioteca_sena.ui.theme.BrandPurple
import com.sena.biblioteca_sena.ui.theme.TextDark
import com.sena.biblioteca_sena.ui.theme.TextGray

@Composable
fun BookDetailSection(
    bookTitle: String,
    modifier: Modifier = Modifier
) {
    // Datos locales de los libros
    val books = listOf(
        BookInfo(
            coverRes = R.drawable.cover_clean_code,
            title = "Clean Code",
            author = "Robert C. Martin",
            category = "Programación",
            description = "Guía práctica para escribir código limpio, legible y fácil de mantener. Un clásico que todo desarrollador debería leer."
        ),
        BookInfo(
            coverRes = R.drawable.cover_kotlin_android,
            title = "Kotlin para Android",
            author = "Antonio J. Gallego y Miguel Á. Lozano",
            category = "Desarrollo móvil",
            description = "Curso completo para aprender a crear aplicaciones Android con Kotlin, desde los conceptos básicos hasta proyectos reales."
        ),
        BookInfo(
            coverRes = R.drawable.cover_hardware,
            title = "Fundamentos de Hardware",
            author = "Juan Carlos Moreno Pérez",
            category = "Hardware",
            description = "Introducción a los componentes del computador: procesador, memoria, almacenamiento y periféricos, y cómo se montan y mantienen."
        ),
        BookInfo(
            coverRes = R.drawable.cover_jetpack_compose,
            title = "Jetpack Compose",
            author = "Neil Smyth",
            category = "Desarrollo móvil",
            description = "Guía paso a paso para construir interfaces modernas en Android con Jetpack Compose, usando composables, estado y navegación."
        )
    )

    // Toma de la lista el libro cuyo título llegó como parámetro
    val book = books.first { it.title == bookTitle }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ParameterBadge(
            iconRes = R.drawable.ic_download,
            text = "Parámetro recibido",
            color = AccentOrange
        )

        BookCover(imageRes = book.coverRes, title = book.title, height = 200.dp)

        // Datos del libro alineados en columnas
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            InfoRow(label = "Nombre:", value = book.title)
            InfoRow(label = "Autor:", value = book.author)
            InfoRow(label = "Categoría:", value = book.category, valueColor = BrandPurple)
        }

        // Descripción: etiqueta arriba y párrafo debajo
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(text = "Descripción:", color = TextDark, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            Text(text = book.description, color = TextGray, fontSize = 14.sp, lineHeight = 20.sp)
        }
    }
}

// Molde de los datos de un libro en el detalle. Es privado: solo se usa en este archivo.
private data class BookInfo(
    @DrawableRes val coverRes: Int,
    val title: String,
    val author: String,
    val category: String,
    val description: String
)