package com.socialclub.app.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.socialclub.app.R
import com.socialclub.app.data.Person
import com.socialclub.app.data.Post
import com.socialclub.app.data.Story
import com.socialclub.app.ui.theme.*
import com.socialclub.app.utils.prettyCount
import kotlin.math.abs

@Composable
fun HomeScreen() {

    val persons: List<Person> = listOf(
        Person("Anastasia", -1, listOf(Story(
            "Live",
            20500,
            R.drawable.stories_anastasia,
            "Game on!"
        )), listOf()),
        Person("Hannah", -1, listOf(Story(
            "Premiere",
            0,
            R.drawable.stories_hannah,
            "The State of Mind"
        )), listOf()),
        Person("James", -1, listOf(Story(
            "Live",
            14600,
            R.drawable.stories_james,
            "Happily married"
        )), listOf()),
        Person("Margaret", -1, listOf(Story(
            "Live",
            5000,
            R.drawable.stories_margaret,
            "Working together with family"
        )), listOf()),
        Person("Robinson", -1, listOf(Story(
            "Live",
            100000,
            R.drawable.stories_robinson,
            "Art Show 2022"
        )), listOf()),
    )
    // Temp data
    val trendingPost = listOf(
        Person(
            "Annette",
            R.drawable.annette_profile,
            listOf(),
            listOf(
                Post(
                    "Hello My Friends, Today I Did Skydiving For The First Time It Was A Crazy Experience.",
                    "#travel #time #skydiving #firstime #viral",
                    R.drawable.trend_skydiving,
                    "2 mins ago"
                )
            )
        )
    );

    val discoverPost = listOf(
        Person(
            "John",
            R.drawable.john_profile,
            listOf(),
            listOf(
                Post(
                    "Hello My Friends, Today I Did Skydiving For The First Time It Was A Crazy Experience.",
                    "#travel #time #skydiving #firstime #viral",
                    R.drawable.discover_snow_boarding,
                    "2 mins ago"
                )
            )
        )
    )

    Column {
        HeaderUI()
        StoriesUI(persons)
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            PostCollection("Trending", trendingPost)
            PostCollection("Discover", discoverPost)
        }
    }
}

@Composable
fun HeaderUI() {
    var isVisible by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { isVisible != isVisible }) {
                Box {
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
fun StoriesUI(persons: List<Person>) {
    Column(modifier = Modifier.padding(top = 15.dp, bottom = 15.dp)) {
        Text(modifier = Modifier.padding(start = 15.dp), text = stringResource(id = R.string.stories), style = Typography.h2)
        LazyRow(modifier = Modifier.padding(top = 10.dp)) {
            items(persons.size){
                StoryCard(persons[it])
            }
        }
    }
}

