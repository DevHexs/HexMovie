package com.hex.movie.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.google.android.material.tabs.TabLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.hex.movie.view.main.SectionsPagerAdapter
import com.hex.movie.databinding.ActivityMainBinding
import com.hex.movie.view.search.MovieSearchAdapter
import com.hex.movie.viewModel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this,lifecycle,supportFragmentManager)
        val viewPager: ViewPager2 = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter

        val tabs: TabLayout = binding.tabs
        TabLayoutMediator(tabs,viewPager) { tab, position ->
            tab.text = sectionsPagerAdapter.getPageTitle(position)
        }.attach()

        viewModel.moviePageData.observe(this){
            it?.let {
                binding.recyclerSearchMovies.adapter = MovieSearchAdapter(it.results, supportFragmentManager)
            }
        }

        val searchView = binding.searchView
        searchView.editText.setOnEditorActionListener { _, _, _ ->
            if (searchView.text.isNullOrEmpty())
                Toast.makeText(this,"Empty text", Toast.LENGTH_LONG).show()
            else
                viewModel.onSearch(searchView.text.toString())
            return@setOnEditorActionListener false
        }

    }

    override fun onBackPressed(){
        if(binding.searchView.isShowing){
            binding.searchView.hide()
            binding.recyclerSearchMovies.adapter = MovieSearchAdapter(
                listOf(),
                supportFragmentManager
            )
        }else{
            super.onBackPressed()
        }
    }
}