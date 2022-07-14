package com.socialclub.app.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun SocialClubTheme(content: @Composable () -> Unit) {

    MaterialTheme(
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}