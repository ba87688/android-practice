package com.example.ukrainiannews.data

import androidx.room.Entity


@Entity(tableName = "articles")
data class NewsArticle (val title:String?,
val url:String,
val thumbnailUrl:String?,
val isBookmark:Boolean,
val updatedAt: Long = System.currentTimeMillis()
){
}