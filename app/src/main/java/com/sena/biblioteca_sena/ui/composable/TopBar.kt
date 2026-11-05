package com.sena.biblioteca_sena.ui.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.biblioteca_sena.ui.theme.BrandPurple
import com.sena.biblioteca_sena.ui.theme.TextDark

@Composable
fun TopBar(
    @DrawableRes navigationIconRes: Int,
    navigationDescription: String,
    title: String,
    onNavigationClick: () -> Unit,
    @DrawableRes actionIconRes: Int? = null
) {
    // Row: ícono izquierdo, título y (opcional) ícono derecho
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onNavigationClick) {
            Icon(
                painter = painterResource(id = navigationIconRes),
                contentDescription = navigationDescription,
                tint = TextDark
            )
        }
        Text(
            text = title,
            color = TextDark,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(1f)
        )
        if (actionIconRes != null) {
            Icon(
                painter = painterResource(id = actionIconRes),
                contentDescription = null,
                tint = BrandPurple,
                modifier = Modifier
                    .padding(end = 12.dp)
                    .size(24.dp)
            )
        }
    }
}