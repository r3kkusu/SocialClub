package com.socialclub.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.socialclub.app.R
import com.socialclub.app.data.Person
import com.socialclub.app.data.Story
import com.socialclub.app.ui.theme.DeepBlack
import com.socialclub.app.ui.theme.ShallowRed
import com.socialclub.app.ui.theme.SmileyGreen
import com.socialclub.app.ui.theme.Typography
import com.socialclub.app.utils.prettyCount
import kotlin.math.abs


@Composable
fun StoryCard(person: Person) {
    val story: Story = person.stories.get(0)
    Column(modifier = Modifier.padding(start = 4.dp, end = 4.dp)) {
        Card(modifier = Modifier.size(100.dp, 150.dp), shape = RoundedCornerShape(18.dp)) {
            Image(
                painter = painterResource(id = story.resource),
                modifier = Modifier
                    .aspectRatio(abs(150f / 40f), true)
                    .fillMaxWidth(),
                contentDescription = story.title
            )
            Box {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .height(25.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(if (story.state == "Premiere") ShallowRed else DeepBlack)
                        .padding(start = 4.dp, top = 2.dp, end = 4.dp, bottom = 2.dp)) {
                        Text(text = story.state, style = Typography.subtitle1)
                    }
                    if (story.state != "Premiere") {
                        Text(modifier = Modifier.padding(start = 4.dp), text = prettyCount(story.views), style = Typography.subtitle1)
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = person.name,
                style = Typography.h4)
            Icon(
                modifier = Modifier
                    .size(18.dp)
                    .padding(start = 5.dp),
                painter = painterResource(id = R.drawable.ic_baseline_check_circle_24),
                contentDescription = stringResource(id = R.string.active),
                tint = SmileyGreen
            )
        }
    }
}
