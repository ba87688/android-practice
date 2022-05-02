package com.example.ukrainiannews.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface NewsArticleDao {

    @Query("SELECT * FROM breaking_news INNER JOIN articles ON articleUrl=url")
    fun getAllBreakingNewsArticles(): Flow<List<NewsArticle>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArt(articles: List<NewsArticle>)

    suspend fun insertBreakingNews(breakingNews: List<BreakingNews>)

    @Query("DELETE FROM breaking_news")
    suspend fun deleteAllNews()
}