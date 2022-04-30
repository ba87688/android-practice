package com.example.ukrainiannews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.ukrainiannews.databinding.ActivityMainBinding
import com.example.ukrainiannews.features.bookmarking.BookmarksFragment
import com.example.ukrainiannews.features.breakingnews.BreakingNewsFragment
import com.example.ukrainiannews.features.newssearch.SearchNewsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //create properties for fragments
    private lateinit var breakingNewsFrag: BreakingNewsFragment
    private lateinit var searchNewsFrag: SearchNewsFragment
    private lateinit var bookMarkFrag: BookmarksFragment


    //array to contain fragmens
    private val fragments: Array<Fragment>
        get() = arrayOf(
            breakingNewsFrag,
            searchNewsFrag,
            bookMarkFrag
        )
    //when act is create, these fragments are not initilaized yet.
    //getter accesses these properties only after we initalized the fragments

    private var selectedIndex = 0

    private val selectedFragment get() = fragments[selectedIndex]

    //selected fragment put on screen
    private fun selectedFragment(selectedFragment: Fragment) {
        var transaction = supportFragmentManager.beginTransaction()
        fragments.forEachIndexed { index, fragment ->
            if (selectedFragment == fragment) {
                transaction = transaction.attach(fragment)
            } else {
                transaction = transaction.detach(fragment)
            }
        }
        transaction.commit()

        title = when (selectedFragment){
            is BreakingNewsFragment -> getString(R.string.home)
            is SearchNewsFragment -> getString(R.string.search)
            is BookmarksFragment -> getString(R.string.bookmarks)
            else -> ""
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (savedInstanceState == null) {
            //onCreate
            //initialize 3 fragments
            breakingNewsFrag = BreakingNewsFragment()
            searchNewsFrag = SearchNewsFragment()
            bookMarkFrag = BookmarksFragment()

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, breakingNewsFrag, TAG_BREAKING_NEWS_FRAGMENT)
                .add(R.id.fragment_container, searchNewsFrag, TAG_SEARCH_NEWS_FRAGMENT)
                .add(R.id.fragment_container, bookMarkFrag, TAG_BOOKMARK_NEWS_FRAGMENT)
                .commit()
        } else {
            //if saved instance state is not null
            breakingNewsFrag =
                supportFragmentManager.findFragmentByTag(TAG_BREAKING_NEWS_FRAGMENT) as BreakingNewsFragment
            searchNewsFrag =
                supportFragmentManager.findFragmentByTag(TAG_SEARCH_NEWS_FRAGMENT) as SearchNewsFragment
            bookMarkFrag =
                supportFragmentManager.findFragmentByTag(TAG_BOOKMARK_NEWS_FRAGMENT) as BookmarksFragment

            selectedIndex = savedInstanceState.getInt(SELECTED_INDEX_KEY,0)
        }

        //call method that selects fragment
        selectedFragment(selectedFragment)
        binding.buttonNav.setOnNavigationItemSelectedListener { i ->
            val fragment = when(i.itemId){
                R.id.home_nav -> breakingNewsFrag
                R.id.search_nav -> searchNewsFrag
                R.id.bookmark_nav ->bookMarkFrag
                else -> throw IllegalArgumentException("NOt expected id.")
            }
            selectedFragment(fragment)
            true
        }

    }

    override fun onBackPressed() {
        if(selectedIndex!=0){
            binding.buttonNav.selectedItemId = R.id.home_nav

        }
        else{
            super.onBackPressed()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SELECTED_INDEX_KEY,selectedIndex)
    }
}


private const val TAG_BREAKING_NEWS_FRAGMENT = "TAG_BREAKING_NEWS_FRAGMENT"
private const val TAG_SEARCH_NEWS_FRAGMENT = "TAG_SEARCH_NEWS_FRAGMENT"
private const val TAG_BOOKMARK_NEWS_FRAGMENT = "TAG_BOOKMARK_NEWS_FRAGMENT"
private const val SELECTED_INDEX_KEY = "SELECTED_INDEX_KEY"
