package com.hex.movie.data.network

import com.hex.movie.data.model.movie.MoviePageData
import com.hex.movie.data.repo.SearchMovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchMovieService @Inject constructor(private val searchMovieRepository: SearchMovieRepository){

    suspend fun getSearchMovie(value: String): MoviePageData {
        return withContext(Dispatchers.IO){
            val response = searchMovieRepository.getMovieSearch(value = value)
            response ?: MoviePageData()
        }
    }
}