package com.example.ukrainiannews.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "articles")
data class NewsArticle(
    val title: String?,
    @PrimaryKey val url: String,
    val thumbnailUrl: String?,
    val isBookmark: Boolean,
    val updatedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "breaking_news")
data class BreakingNews(
    val articleUrl:String,
    @PrimaryKey(autoGenerate = true)val id:Int = 0
)