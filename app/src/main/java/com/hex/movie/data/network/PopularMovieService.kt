package com.hex.movie.data.network

import com.hex.movie.data.model.popular.MoviePopularsData
import com.hex.movie.data.repo.PopularMovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PopularMovieService @Inject constructor(private val popularMovieRepository: PopularMovieRepository){
    suspend fun getPopularMovie(): MoviePopularsData {
        return withContext(Dispatchers.IO){
            val response = popularMovieRepository.getPopularMovie()
            response
        }
    }
}