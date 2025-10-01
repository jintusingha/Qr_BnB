package com.jintu.qr_bnb.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jintu.qr_bnb.ui.theme.QrBnbCardText
import com.jintu.qr_bnb.ui.theme.QrBnbTopText






@Composable
fun AppScreenTitle(
    text: String,
    modifier: Modifier = Modifier
) {

    Text(
        text = text,
        style = MaterialTheme.typography.QrBnbTopText

    )


}

@Composable
fun AppCardTextStyle(
    text:String
){
    Text(
        text=text,
        style = MaterialTheme.typography.QrBnbCardText
    )
}


@Composable
fun AppCategoryHeader(
    text:String,
    modifier: Modifier= Modifier

){
    Text(
        text=text,
        style = MaterialTheme.typography.titleLarge,
        modifier=modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun AppBottomNavBarLabel(
    text:String
){
    Text(
        text=text,
        style = MaterialTheme.typography.titleSmall
    )
}