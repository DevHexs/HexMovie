package com.hex.movie.view.latest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import coil.load
import com.hex.movie.databinding.FragmentMovieLatestBinding
import com.hex.movie.viewModel.MovieLatestViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieLatestFragment : Fragment() {

    private lateinit var binding: FragmentMovieLatestBinding

    private val viewModel by viewModels<MovieLatestViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onCreate()

        viewModel.movieLatest.observe(viewLifecycleOwner){
            binding.tvTitle.text = it.originalTitle
            binding.tvOverview.text = it.overview
            if(it.imgUrl.isNullOrEmpty())
                binding.imageView.load(getImage(it.imgUrl))
        }

        viewModel.isLoading.observe(viewLifecycleOwner){
            binding.swipeRefresh.isRefreshing = it

            if (it) {
                binding.movieLayout.visibility = View.INVISIBLE
            }else{
                binding.movieLayout.visibility = View.VISIBLE
            }

        }

        setupOnRefresh()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =  FragmentMovieLatestBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setupOnRefresh(){
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.onCreate()
        }
    }

    private fun getImage(url: String): String = "https://image.tmdb.org/t/p/original/{$url}"

}