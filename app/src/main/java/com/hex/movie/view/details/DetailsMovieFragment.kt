package com.hex.movie.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import coil.load
import com.hex.movie.R
import com.hex.movie.databinding.DialogDetailsMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsMovieFragment(): DialogFragment() {

    private lateinit var binding: DialogDetailsMovieBinding

    override fun getTheme() = R.style.DialogTheme

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = Bundle(arguments)

        binding.tvTitle.text = bundle.getString("Title")
        binding.tvOverview.text = bundle.getString("Overview")
        binding.imageView.load(bundle.getString("Url"))
        binding.tvAverageRate.text = bundle.getString("VoteAverage")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =  DialogDetailsMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

}