package com.example.ukrainiannews.data

import com.example.ukrainiannews.api.NewsApi
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsApi: NewsApi,
private val newsArticleDb: NewsArticleDatabase) {

    private val newsArticleDao = newsArticleDb.newsArticleDao()

    suspend fun getBreakingNews(): List<NewsArticle>{
        val response = newsApi.getBreakingNews()
        val serverBreakingNewsArticle = response.articles
        val breakingNewsArticles = serverBreakingNewsArticle.map { serverBreakingNewsArticle ->
            NewsArticle(
                title = serverBreakingNewsArticle.title,
                url = serverBreakingNewsArticle.url,
                thumbnailUrl = serverBreakingNewsArticle.urlToImage,
                isBookmark = false)

        }
        return breakingNewsArticles
    }
}