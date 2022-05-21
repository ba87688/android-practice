package com.example.ukrainiannews.shared

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.ukrainiannews.data.NewsArticle
import com.example.ukrainiannews.databinding.ItemNewsBinding

class ArticleListAdapter : ListAdapter<NewsArticle,NewsArticleViewHolder> (NewsArticleComparitor()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsArticleViewHolder {
        val binding =
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsArticleViewHolder(binding)

    }

    override fun onBindViewHolder(holder: NewsArticleViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem!=null){
            holder.bind(currentItem)
        }
    }
}