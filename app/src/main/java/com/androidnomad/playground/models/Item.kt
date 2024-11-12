package com.androidnomad.playground.models

data class Item(
    val author: Author,
    val created: Long,
    val firstPublished: Long,
    val id: String,
    val lastPublished: Long,
    val locale: String,
    val refresh: String,
    val snippet: String,
    val thumbnail: String,
    val title: String,
    val topics: List<String>,
    val type: String
)