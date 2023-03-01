package com.hex.movie.data.network

import com.hex.movie.data.model.MovieLatestData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LatestMovieService @Inject constructor(private val api: MovieApiClient) {
    suspend fun getLatestMovie(): MovieLatestData{
        return withContext(Dispatchers.IO){
            val response = api.getLatestMovie()
            response.body() ?: MovieLatestData()
        }
    }
}