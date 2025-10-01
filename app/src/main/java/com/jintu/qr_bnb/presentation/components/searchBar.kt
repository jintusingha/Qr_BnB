package com.jintu.qr_bnb.presentation.components



import com.jintu.qr_bnb.R

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jintu.qr_bnb.ui.theme.jakartaFontFamily

@Composable
fun SearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "Search",
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFFFBEFEF),
     placeholderColor: Color = Color(0xFF945454),

            textColor: Color = Color.Black,
    iconTint: Color = Color(0xFFB8B8B8)
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(backgroundColor, RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp),
        textStyle = TextStyle(
            color = textColor,
            fontSize = 14.sp,
            fontFamily = jakartaFontFamily,
            fontWeight = FontWeight.W400
        ),
        singleLine = true,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.searchicon),
                    contentDescription = "Search",
                    tint = Color(0xFF8A5C5C),
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Box(modifier = Modifier.weight(1f)) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = placeholderColor,
                            fontSize = 14.sp,
                            fontFamily = jakartaFontFamily,
                            fontWeight = FontWeight.W400
                        )
                    }
                    innerTextField()
                }
            }
        }
    )
}