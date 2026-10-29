package com.sena.biblioteca_sena.ui.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.biblioteca_sena.ui.theme.TextDark

@Composable
fun InfoRow(
    label: String,
    value: String,
    valueColor: Color = TextDark
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            color = TextDark,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.width(96.dp)
        )
        Text(
            text = value,
            color = valueColor,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f)
        )
    }
}