package com.socialclub.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.socialclub.app.R
import com.socialclub.app.data.Person
import com.socialclub.app.ui.theme.*
import com.socialclub.app.utils.prettyCount

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileScreen(onPressClose = { })
}

@Composable
fun ProfileScreen(onPressClose : (Boolean) -> Unit) {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
        .background(DullBlack)
        .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            GestureButton(onPressClose)
            ProfileAccount()
        }
    }
}

@Composable
fun GestureButton(onPressClose : (Boolean) -> Unit) {

    IconButton( onClick = {
        onPressClose(false)
    }) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .padding(5.dp)
                .size(45.dp, 6.dp)
                .background(DeepBlack)
        ) {}
    }
}

@Composable
fun ProfileAccount() {

    val persons = listOf(
        Person("", R.drawable.john_profile, listOf(), listOf()),
        Person("", R.drawable.annette_profile, listOf(), listOf()),
        Person("", R.drawable.profile_image, listOf(), listOf())
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier
                .padding(top = 20.dp)
                .size(100.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = stringResource(id = R.string.profile_image)
        )
        Row(
            modifier = Modifier.padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Rex James Pinili", style = Typography.h1)
            Icon(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .size(24.dp),
                painter = painterResource(id = R.drawable.ic_baseline_check_circle_24),
                contentDescription = stringResource(id = R.string.active),
                tint = SmileyGreen
            )
        }
        Text(text = "@r3kkusu", style = Typography.h2, color = CloudGray)
        Row(verticalAlignment = Alignment.CenterVertically) {
            FriendsItems("Following", persons, 204)
            FriendsItems("Followers", persons, 2500000)
            FriendsItems("Close Friends", persons, 26)
        }

        Column(modifier = Modifier.align(Alignment.Start)) {
            Text(text = "Inspiring Designers Globally \uD83C\uDF0E", style = Typography.h3)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_link_24),
                    contentDescription = stringResource(id = R.string.link),
                    tint = CloudGray
                )
                Text(modifier = Modifier.padding(start = 5.dp), text = "instagram.com/r3kkusu", style = Typography.h4, color = SkyBlue)
            }
        }
    }
}

@Composable
fun FriendsItems(title: String, person: List<Person>, count: Long) {
    Column(modifier = Modifier.padding(20.dp)) {
        Row(modifier = Modifier.padding(bottom = 10.dp)) {
            // TODO Fix later
            Box {
                for (i in 0..2) {
                    Image(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(RoundedCornerShape(5.dp))
//                            .padding(start = if (i > 0) (i * 10).dp else 0.dp)
                        ,
                        painter = painterResource(id = person[i].profileImage),
                        contentDescription = person[i].name
                    )
                }
            }
            Text(modifier = Modifier.padding(start = 5.dp), text = prettyCount(count), style = Typography.h3)
        }
        Text(text = title, style = Typography.h3, color = CloudGray)
    }
}