package com.hex.movie.view.popular

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.hex.movie.data.model.popular.MoviePopularResultsData
import com.hex.movie.databinding.ItemPopularMovieBinding

class MoviePopularAdapter(private val moviePopularResultsData: List<MoviePopularResultsData>) :
    RecyclerView.Adapter<MoviePopularAdapter.ViewHolder>(){

    inner class ViewHolder(val binding: ItemPopularMovieBinding) :
        RecyclerView.ViewHolder(binding.root)

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPopularMovieBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = moviePopularResultsData.size


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(moviePopularResultsData[position]){
                binding.imageView.load(getImage(this.posterPath!!))
                binding.tvTitle.text = this.title
                binding.tvDate.text = this.releaseDate
                binding.tvAverageRate.text = this.voteAverage.toString()
            }
        }
    }

    private fun getImage(url: String): String = "https://image.tmdb.org/t/p/original$url"
}