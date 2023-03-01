package com.hex.movie.data.repo

import com.hex.movie.data.model.popular.MoviePopularsData
import com.hex.movie.data.network.MovieApiClient
import javax.inject.Inject

class PopularMovieRepository @Inject constructor(
    private val api: MovieApiClient
){
    suspend fun getPopularMovie(): MoviePopularsData {
        val response = api.getPopularsMovie()
        return response.body()!!
    }
}