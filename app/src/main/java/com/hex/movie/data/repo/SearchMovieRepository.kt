package com.hex.movie.data.repo

import com.hex.movie.data.model.movie.MoviePageData
import com.hex.movie.data.network.MovieApiClient
import javax.inject.Inject

class SearchMovieRepository @Inject constructor(
    private val api: MovieApiClient)
{
    suspend fun getMovieSearch(value: String): MoviePageData? {
        val response = api.getSearchMovie(query = value)
        return response.body()
    }
}