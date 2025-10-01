package com.jintu.qr_bnb.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jintu.qr_bnb.ui.theme.jakartaFontFamily


@Composable
fun AddToCartButton(
    onAddToCart: () -> Unit,
    modifier: Modifier = Modifier,
    buttonColor: Color = Color(0xFFE57373),
    textColor: Color = Color.White
) {
    Box(
        modifier = modifier
            .width(120.dp)
            .height(36.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(buttonColor)
            .clickable { onAddToCart() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Add to Cart",
            color = textColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.W600,
            fontFamily = jakartaFontFamily
        )
    }
}