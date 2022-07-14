package com.socialclub.app.data

data class Person(
    val name: String,
    val profileImage: Int,
    val stories: List<Story>,
    val posts: List<Post>
)
