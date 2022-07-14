package com.socialclub.app.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.socialclub.app.R

val gilroy = FontFamily(
    listOf(
        Font(R.font.gilroy_regular, FontWeight.Normal),
        Font(R.font.gilroy_medium, FontWeight.Medium),
        Font(R.font.gilroy_bold, FontWeight.Bold),
        Font(R.font.gilroy_thin, FontWeight.Thin),
        Font(R.font.gilroy_light, FontWeight.Light),
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        color = SoftWhite,
        fontFamily = gilroy,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        color = CloudGray,
        fontFamily = gilroy,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        color = SoftWhite,
        fontFamily = gilroy,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp
    ),
    h1 = TextStyle(
        color = SoftWhite,
        fontFamily = gilroy,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    h2 = TextStyle(
        color = SoftWhite,
        fontFamily = gilroy,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    h3 = TextStyle(
        color = SoftWhite,
        fontFamily = gilroy,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    h4 = TextStyle(
        color = SoftWhite,
        fontFamily = gilroy,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    )
)