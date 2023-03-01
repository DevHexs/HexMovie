package com.hex.movie.data.repo

import com.hex.movie.data.model.MovieLatestData
import com.hex.movie.data.model.MovieLatestProvider
import com.hex.movie.data.network.MovieApiClient
import javax.inject.Inject

class LatestMovieRepository @Inject constructor(
    private val api: MovieApiClient,
    private val provider: MovieLatestProvider)
{
    suspend fun getMovieLatest(): MovieLatestData{
        val response = api.getLatestMovie()
        provider.movieLatest = response.body()!!
        return provider.movieLatest
    }
}