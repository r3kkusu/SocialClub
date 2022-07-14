package com.socialclub.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.socialclub.app.R
import com.socialclub.app.data.Person
import com.socialclub.app.ui.theme.*


@Composable
fun PostCollection(title: String, persons: List<Person>) {

    Column(modifier = Modifier.padding(start = 15.dp, top = 10.dp, end = 15.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = title, fontSize = 25.sp, style = Typography.h1)
            Box {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = stringResource(id = R.string.more),
                        style = Typography.h4,
                        color = JoyfulYellow
                    )
                    Icon(
                        modifier = Modifier
                            .padding(start = 3.dp)
                            .size(14.dp),
                        painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_24),
                        contentDescription = stringResource(id = R.string.forward_arrow),
                        tint = JoyfulYellow
                    )
                }
            }
        }

        PostStack(persons);
    }

}

@Composable
fun PostStack(persons: List<Person>) {
    Box(modifier = Modifier.padding(top = 15.dp),
        contentAlignment = Alignment.Center) {
        PostCard(persons[0])
    }
}

@Composable
fun PostCard(person: Person) {

    val post = person.posts[0]

    Column(modifier = Modifier
        .heightIn(350.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(30.dp))
        .background(DullBlack)) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 14.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(SoftWhite)) {

            Image(
                contentScale = ContentScale.None,
                painter = painterResource(id = post.resource),
                contentDescription = post.description
            )

            IconButton(modifier = Modifier
                .clip(RoundedCornerShape(topStart = 20.dp))
                .background(JoyfulYellow)
                .align(Alignment.BottomEnd)
                .width(70.dp), onClick = { /*TODO*/ }) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = R.drawable.ic_baseline_thumb_up_24),
                        contentDescription = stringResource(id = R.string.like),
                        tint = DarkYellow
                    )
                    Text(
                        modifier = Modifier.padding(start = 4.dp),
                        text = stringResource(id = R.string.like),
                        style = Typography.h4,
                        color = DarkYellow
                    )
                }
            }
        }

        Row(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Box() {
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    painter = painterResource(id = person.profileImage),
                    contentDescription = stringResource(id = R.string.profile_image)
                )
                Box(modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(PastelGreen)
                    .border(2.dp, DeepBlack, shape = CircleShape)
                    .align(Alignment.BottomEnd))
            }

            Column(modifier = Modifier.padding(start = 6.dp)) {
                Text(text = person.name, style = Typography.h3)
                Text(text = post.time, style = Typography.body2)
            }
        }

        Text(
            modifier = Modifier.padding(start = 20.dp, top = 10.dp, end = 20.dp),
            text = post.description,
            style = Typography.body1)

        Text(
            modifier = Modifier.padding(start = 20.dp, top = 10.dp, end = 20.dp),
            text = post.hashtags,
            style = Typography.body2,
            fontWeight = FontWeight.Bold
        )
    }
}