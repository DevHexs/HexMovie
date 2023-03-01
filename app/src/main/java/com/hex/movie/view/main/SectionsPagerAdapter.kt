package com.hex.movie.view.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hex.movie.R
import com.hex.movie.view.MainActivity
import com.hex.movie.view.latest.MovieLatestFragment
import com.hex.movie.view.popular.MoviePopularsFragment

private val TAB_TITLES = arrayOf(R.string.tab_text_1, R.string.tab_text_2)

class SectionsPagerAdapter(
    private val context: MainActivity,
    lifecycle: Lifecycle,
    fm: FragmentManager)
    : FragmentStateAdapter(fm, lifecycle) {

    fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getItemCount(): Int = TAB_TITLES.size

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MoviePopularsFragment()
            else -> MovieLatestFragment()
        }
    }
}