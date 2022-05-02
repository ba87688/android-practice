package com.example.ukrainiannews.features.breakingnews

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ukrainiannews.R
import com.example.ukrainiannews.databinding.BreakingNewsFragmentBinding
import com.example.ukrainiannews.shared.ArticleListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class BreakingNewsFragment : Fragment(R.layout.breaking_news_fragment) {

    //use viewmodel
    private val viewModel:BreakingNewsViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = BreakingNewsFragmentBinding.bind(view)

        val newsArticleAdapter = ArticleListAdapter()

        binding.apply {
            recyclerViewSwipeRefresh.apply {
                adapter = newsArticleAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }

            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                //collect data
                viewModel.breakingNews.collect{ articles ->
                    newsArticleAdapter.submitList(articles)
            }


            }
        }
    }
}