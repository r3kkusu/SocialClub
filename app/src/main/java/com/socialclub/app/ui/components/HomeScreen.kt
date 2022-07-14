package com.socialclub.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.socialclub.app.R
import com.socialclub.app.ui.theme.*

@Composable
fun HomeScreen() {
    Column {
        HeaderUI()
    }
}

@Composable
fun HeaderUI() {
    Row(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box() {
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = stringResource(id = R.string.profile_image)
                )
                Box(modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(ShallowRed)
                    .border(2.dp, DeepBlack, shape = CircleShape)
                    .align(Alignment.BottomEnd))
            }
            Column(modifier = Modifier.padding(start = 8 .dp)) {
                Text(text = "Rex James Pinili", style = Typography.h2)
                Text(text = "@r3kkusu", style = Typography.body2)
            }
        }
        IconButton(onClick = { /* TODO */ }) {
            Box(modifier = Modifier
                .clip(CircleShape)
                .background(DullBlack)
                .size(45.dp)) {
                Icon(
                    modifier = Modifier.align(Alignment.Center),
                    painter = painterResource(id = R.drawable.ic_baseline_search_24),
                    contentDescription = stringResource(id = R.string.search),
                    tint = SoftGray
                )
            }
        }
    }
}


@Composable
fun StoriesUI() {
    Column() {
        Text(text = stringResource(id = R.string.stories), style = Typography.h2)
        LazyRow {}
    }
}