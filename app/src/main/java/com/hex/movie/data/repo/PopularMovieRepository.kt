package com.hex.movie.data.repo

import com.hex.movie.data.model.movie.MoviePageData
import com.hex.movie.data.network.MovieApiClient
import javax.inject.Inject

class PopularMovieRepository @Inject constructor(
    private val api: MovieApiClient
){
    suspend fun getPopularMovie(): MoviePageData {
        val response = api.getPopularsMovie()
        return response.body()!!
    }
}