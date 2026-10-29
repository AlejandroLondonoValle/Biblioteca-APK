package com.sena.biblioteca_sena.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.biblioteca_sena.R
import com.sena.biblioteca_sena.ui.composable.ActionButton
import com.sena.biblioteca_sena.ui.composable.ButtonRow
import com.sena.biblioteca_sena.ui.section.WelcomeSection
import com.sena.biblioteca_sena.ui.theme.BrandPurple


@Composable
fun HomeScreen(
    onirBookList: () -> Unit,
){

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(140.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            WelcomeSection()


            ButtonRow {
                ActionButton(
                    iconRes = R.drawable.ic_menu_book,
                    text = "Ver Libros",
                    color = BrandPurple,
                    onClick = onirBookList
                )
            }
        }

    }}