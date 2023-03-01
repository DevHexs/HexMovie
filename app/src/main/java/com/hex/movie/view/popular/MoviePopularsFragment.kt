package com.hex.movie.view.popular

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.hex.movie.databinding.FragmentMoviePopularsBinding
import com.hex.movie.viewModel.MoviePopularViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviePopularsFragment : Fragment() {

    private lateinit var binding: FragmentMoviePopularsBinding

    private val viewModel by viewModels<MoviePopularViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onCreate()

        viewModel.moviePageData.observe(viewLifecycleOwner){
            it?.let {
                binding.recyclerPopularMovies.adapter = MoviePopularAdapter(it.results,childFragmentManager)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMoviePopularsBinding.inflate(inflater, container, false)
        return binding.root
    }
}