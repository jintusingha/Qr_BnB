package com.jintu.qr_bnb.ui.theme


import android.R.attr.fontFamily
import android.R.attr.text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jintu.qr_bnb.R
import java.lang.ProcessBuilder.Redirect.to

public val jakartaFontFamily= FontFamily(
    Font(R.font.plusjakartasans_bold, FontWeight.W700),
    Font(R.font.plusjakartasans_medium, FontWeight.W500),
    Font(R.font.plusjakartasansregular, FontWeight.W400)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily=jakartaFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        color = Color.Black
    ),
    titleSmall = TextStyle(
        fontFamily=jakartaFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        color = Color(0xFFA14547)

    ),

    )


val QrBnbCourseDescriptionTextStyle = TextStyle(
    fontFamily = jakartaFontFamily,
    fontWeight = FontWeight.W400,
    fontSize = 14.sp,
    lineHeight = 21.sp,
    color = Color.Gray
)


val Typography.QrBnbCourseDescriptionText: TextStyle
    @Composable
    get() = QrBnbCourseDescriptionTextStyle









// the below code we will use when we want to set some custom typography in our app
val QrBnbTopTextStyle = TextStyle(
    fontFamily = jakartaFontFamily,
    fontWeight = FontWeight.W700,
    fontSize = 18.sp,
    lineHeight = 23.sp,
    color = Color.Black
)


val Typography.QrBnbTopText: TextStyle
    @Composable
    get() = QrBnbTopTextStyle


val QrBnbCardTextstyle= TextStyle(
    fontFamily =jakartaFontFamily,
    fontWeight = FontWeight.W500,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    color = Color.Black

)

val Typography.QrBnbCardText: TextStyle
@Composable
get()=QrBnbCardTextstyle

