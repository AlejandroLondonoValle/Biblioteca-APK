package com.sena.biblioteca_sena.ui.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.biblioteca_sena.ui.theme.SuccessGreen
import com.sena.biblioteca_sena.ui.theme.TextDark
import com.sena.biblioteca_sena.ui.theme.TextGray

@Composable
fun IconInfoItem(
    @DrawableRes iconRes: Int,
    label: String,
    value: String
) {
    // Row: ícono a la izquierda; etiqueta y valor apilados a la derecha
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = SuccessGreen,
            modifier = Modifier.size(28.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = label, color = TextGray, fontSize = 13.sp)
            Text(text = value, color = TextDark, fontSize = 17.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}