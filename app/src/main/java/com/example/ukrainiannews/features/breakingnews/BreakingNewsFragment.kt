package com.example.ukrainiannews.features.breakingnews

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.ukrainiannews.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreakingNewsFragment : Fragment(R.layout.breaking_news_fragment) {

    //use viewmodel
    private val viewModel:BreakingNewsViewModel by viewModels()


}