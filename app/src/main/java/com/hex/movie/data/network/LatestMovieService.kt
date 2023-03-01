package com.hex.movie.data.network

import com.hex.movie.data.model.MovieLatestData
import com.hex.movie.data.repo.LatestMovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LatestMovieService @Inject constructor(private val latestMovieRepository: LatestMovieRepository) {
    suspend fun getLatestMovie(): MovieLatestData{
        return withContext(Dispatchers.IO){
            val response = latestMovieRepository.getMovieLatest()
            response
        }
    }
}