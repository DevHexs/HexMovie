package com.hex.movie.data.repo

import com.hex.movie.data.model.latest.MovieLatestData
import com.hex.movie.data.network.MovieApiClient
import javax.inject.Inject

class LatestMovieRepository @Inject constructor(
    private val api: MovieApiClient)
{
    suspend fun getMovieLatest(): MovieLatestData{
        val response = api.getLatestMovie()
        return response.body()!!

    }
}