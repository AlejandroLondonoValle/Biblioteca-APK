package com.sena.biblioteca_sena.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sena.biblioteca_sena.ui.theme.TextDark
import com.sena.biblioteca_sena.ui.theme.TextGray

@Composable
fun LabeledText(
    label: String,
    value: String
) {
    Column {
        Text(text = label, color = TextGray, fontSize = 13.sp)
        Text(text = value, color = TextDark, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
    }
}
