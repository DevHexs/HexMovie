package com.hex.movie.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
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
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =  FragmentMovieLatestBinding.inflate(inflater, container, false)
        return binding.root
    }
}