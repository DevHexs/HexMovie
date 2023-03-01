package com.hex.movie.domain

import com.hex.movie.data.model.movie.MoviePageData
import com.hex.movie.data.network.SearchMovieService
import javax.inject.Inject

class GetMovieSearchUseCase @Inject constructor(
    private val searchMovieService: SearchMovieService
) {
    suspend operator fun invoke(value: String):
            MoviePageData = searchMovieService.getSearchMovie(value)
}