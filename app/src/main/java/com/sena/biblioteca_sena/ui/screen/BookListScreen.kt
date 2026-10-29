package com.sena.biblioteca_sena.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sena.biblioteca_sena.ui.section.BookListSection
import com.sena.biblioteca_sena.ui.theme.BackgroundLight

@Composable
fun BookListScreen(
    onirBookDetail: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
    ) {
        BookListSection(
            onBookClick = onirBookDetail,
            modifier = Modifier.weight(1f)
        )
    }
}