package com.sena.biblioteca_sena.ui.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BookCover(
    @DrawableRes imageRes: Int,
    title: String,
    height: Dp
) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = "Portada del libro $title",
        modifier = Modifier
            .height(height)
            .aspectRatio(0.7f, matchHeightConstraintsFirst = true)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(6.dp))
            .clip(RoundedCornerShape(6.dp)),
        contentScale = ContentScale.Crop
    )
}