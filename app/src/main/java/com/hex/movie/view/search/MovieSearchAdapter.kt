package com.hex.movie.view.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.hex.movie.data.model.movie.MovieListData
import com.hex.movie.databinding.ItemSearchMovieBinding
import com.hex.movie.view.details.DetailsMovieFragment

class MovieSearchAdapter(
    private val movieListData: List<MovieListData>,
    private val fm: FragmentManager
):
    RecyclerView.Adapter<MovieSearchAdapter.ViewHolder>(){

    inner class ViewHolder(val binding: ItemSearchMovieBinding):
        RecyclerView.ViewHolder(binding.root)

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSearchMovieBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = movieListData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(movieListData[position]){
                binding.imageView.load(getImage(this.posterPath))
                binding.tvTitle.text = this.title
                binding.tvAverageRate.text = "%.1f".format(this.voteAverage)

                binding.imageView.setOnClickListener {
                    val f = DetailsMovieFragment()
                    val bundle = Bundle()
                    bundle.putString("Title", this.title)
                    bundle.putString("Overview", this.overview)
                    bundle.putString("Url", getImage(this.posterPath))
                    bundle.putString("VoteAverage", "%.1f".format(this.voteAverage))
                    f.arguments = bundle
                    f.show(fm,f.tag)
                }
            }
        }
    }


    private fun getImage(url: String?): String {
        return if (!url.isNullOrEmpty())
            "https://image.tmdb.org/t/p/original$url"
        else
            "https://static.wikia.nocookie.net/ideas/images/6/66/FoxAndroidTM2%27s_No_Poster.jpg/revision/latest?cb=20230213155127"
    }
}