package com.example.ukrainiannews.shared

import androidx.recyclerview.widget.DiffUtil
import com.example.ukrainiannews.data.NewsArticle

class NewsArticleComparitor : DiffUtil.ItemCallback<NewsArticle>() {
    override fun areItemsTheSame(oldItem: NewsArticle, newItem: NewsArticle) =
        oldItem.url  == newItem.url

    override fun areContentsTheSame(oldItem: NewsArticle, newItem: NewsArticle) =
        oldItem == newItem
}