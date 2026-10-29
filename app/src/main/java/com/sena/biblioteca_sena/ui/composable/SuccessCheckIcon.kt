package com.sena.biblioteca_sena.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sena.biblioteca_sena.R
import com.sena.biblioteca_sena.ui.theme.SuccessGreen

@Composable
fun SuccessCheckIcon() {
    Box(
        modifier = Modifier
            .size(140.dp)
            .clip(CircleShape)
            .background(SuccessGreen.copy(alpha = 0.12f)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_check),
            contentDescription = "Operación exitosa",
            tint = SuccessGreen,
            modifier = Modifier.size(90.dp)
        )
    }
}
