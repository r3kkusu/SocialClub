package com.socialclub.app.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.socialclub.app.ui.components.HomeScreen
import com.socialclub.app.ui.theme.DeepBlack

@Composable
fun AppSocialClub() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = DeepBlack
    ) {
        HomeScreen()
    }
}