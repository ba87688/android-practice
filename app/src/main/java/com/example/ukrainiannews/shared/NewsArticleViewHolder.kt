package com.example.ukrainiannews.shared

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ukrainiannews.R
import com.example.ukrainiannews.data.NewsArticle
import com.example.ukrainiannews.databinding.ActivityMainBinding
import com.example.ukrainiannews.databinding.ItemNewsBinding

class NewsArticleViewHolder (private val binding: ItemNewsBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article:NewsArticle){
        binding.apply {
            Glide.with(itemView)
                .load(article.thumbnailUrl)
                .error(R.drawable.error_draw)
                .into(imageView)

            titleTextView.text =article.title ?:""

            bookmarkImageView.setImageResource(
                when{
                    article.isBookmark -> R.drawable.ic_bookmark
                    else -> R.drawable.ic_no_bookmark
                }
            )
        }
    }
}